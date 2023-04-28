package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    private int x2;
    private int y2;
    private Color fillColor;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public int area() {
        return 0;
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.getX() > this.x2 ? this.x2 : this.getX(), this.getY() > this.y2 ? this.y2 : this.getY()), Math.abs(this.x2 - this.getX()), Math.abs(this.y2 - this.getY()));
    }

    @Override
    public double[][] getCoordinates() {
        double width = this.getX2() - this.getX();
        double height = this.getY2() - this.getY();

        Vector3 leftTop = new Vector3(new double[]{this.getX(), this.getY(), 1});
        Vector3 rightTop = new Vector3(new double[]{this.getX() + width, this.getY(), 1});
        Vector3 leftBottom = new Vector3(new double[]{this.getX(), this.getY() + height, 1});
        Vector3 rightBottom = new Vector3(new double[]{this.getX() + width, this.getY() + height, 1});
        Vector3[] rectangleCorners = new Vector3[]{leftTop, rightTop, rightBottom, leftBottom};

        Matrix3 translateOrigin = TransformFactory.createTranslation(this.getX() + (int)width / 2, this.getY() + (int)height / 2);
        Matrix3 inverseTranslate = TransformFactory.createTranslation(-(this.getX() + (int)width / 2), -(this.getY() + (int)height / 2));

        if (this.transform != null) {
            for (int i = 0; i < rectangleCorners.length; i++) {
                rectangleCorners[i] = translateOrigin.mult(this.transform).mult(inverseTranslate).mult(rectangleCorners[i]);
            }
        }

        double[][] coordinates = new double[2][rectangleCorners.length];
        for (int i = 0; i < rectangleCorners.length; i++) {
            coordinates[0][i] = rectangleCorners[i].getValues()[0];
            coordinates[1][i] = rectangleCorners[i].getValues()[1];
        }

        return coordinates;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = this.getCoordinates();
       /* graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);*/
        graphicsContext.strokeLine(coordinates[0][0], coordinates[1][0], coordinates[0][2], coordinates[1][2]);
    }
}
