package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(Point point, int width, int height) {
        super(point.getX(), point.getY());
        this.width = width;
        this.height = height;
    }

    public int area() {
        return this.width * this.height;
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.getX(), this.getY()), this.width, this.height);
    }

    public boolean isOverlapping(Rectangle other) {
        Point topLeft = new Point(this.getX(), this.getY());
        Point bottomRight = new Point(this.getX() + this.width, this.getY() + this.height);
        Point otherTopLeft = new Point(other.getX(), other.getY());
        Point otherBottomRight = new Point(other.getX() + other.width, other.getY() + other.height);
        return (topLeft.getX() > otherBottomRight.getX() || otherTopLeft.getX() > bottomRight.getX()) || (bottomRight.getY() < otherTopLeft.getY() || otherBottomRight.getY() < topLeft.getY()) ? false : true;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private double[][] getCoordinates() {
        Vector3 leftTop = new Vector3(new double[]{this.getX(), this.getY(), 1});
        Vector3 rightTop = new Vector3(new double[]{this.getX() + this.getWidth(), this.getY(), 1});
        Vector3 leftBottom = new Vector3(new double[]{this.getX(), this.getY() + this.getHeight(), 1});
        Vector3 rightBottom = new Vector3(new double[]{this.getX() + this.getWidth(), this.getY() + this.getHeight(), 1});
        Vector3[] rectangleCorners = new Vector3[]{leftTop, rightTop, rightBottom, leftBottom};

        Matrix3 translateOrigin = TransformFactory.createTranslation(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
        Matrix3 inverseTranslate = TransformFactory.createTranslation(-(this.getX() + this.getWidth() / 2), -(this.getY() + this.getHeight() / 2));

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

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = this.getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
