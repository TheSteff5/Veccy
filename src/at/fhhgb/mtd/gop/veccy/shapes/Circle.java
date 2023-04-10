package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    private int radius;

    public Circle(Point point, int radius) {
        super(point.getX(), point.getY());
        this.radius = radius;
    }

    public Circle(Point point, int radius, Color color) {
        this(point, radius);
        this.fillColor = color;
    }

    public int area() {
        return (int) (Math.PI * (this.radius * this.radius));
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.getX() - this.radius, this.getY() - this.radius), this.radius * 2, this.radius * 2);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private double[][] getCoordinates() {
        Vector3[] circleCoordinatePairs = new Vector3[8];
        double step = (2 * Math.PI) / circleCoordinatePairs.length;

        for (int i = 0; i < circleCoordinatePairs.length; i++) {
            double x = this.getX() + this.radius * Math.cos(step * i);
            double y = this.getY() + this.radius * Math.sin(step * i);
            circleCoordinatePairs[i] = new Vector3(new double[]{x, y, 1.0});
        }

        // ask Prof why the translation is not working inversed, this should be de translateOrigin -(this.getX() + this.getWidth() / 2), -(this.getY() + this.getHeight() / 2)
        Matrix3 translateOrigin = TransformFactory.createTranslation(this.getX(), this.getY());
        Matrix3 inverseTranslate = TransformFactory.createTranslation(-this.getX(), -this.getY());

        if (this.transform != null) {
            for (int i = 0; i < circleCoordinatePairs.length; i++) {
                circleCoordinatePairs[i] = translateOrigin.mult(this.transform).mult(inverseTranslate).mult(circleCoordinatePairs[i]);
            }
        }

        double[][] coordinates = new double[2][circleCoordinatePairs.length];
        for (int i = 0; i < circleCoordinatePairs.length; i++) {
            coordinates[0][i] = circleCoordinatePairs[i].getValues()[0];
            coordinates[1][i] = circleCoordinatePairs[i].getValues()[1];
        }

        return coordinates;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = this.getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
