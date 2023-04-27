package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

public class Point extends Shape {
    public Point(int x, int y) {
        super(x, y);
    }

    public int area() {
        return 0;
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.getX(), this.getY()), 1, 1);
    }

    @Override
    public double[][] getCoordinates() {
        Vector3[] circleCoordinatePairs = new Vector3[256];
        double step = (2 * Math.PI) / circleCoordinatePairs.length;

        for (int i = 0; i < circleCoordinatePairs.length; i++) {
            double x = this.getX() + 2 * Math.cos(step * i);
            double y = this.getY() + 2 * Math.sin(step * i);
            circleCoordinatePairs[i] = new Vector3(new double[]{x, y, 1.0});
        }

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
