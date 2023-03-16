package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements DrawableShape {
    private Point point;
    private int width;
    private int height;
    private Color fillColor;

    public Rectangle(Point point, int width, int height) {
        this.point = point;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point point, int width, int height, Color fillColor) {
        this(point, width, height);
        this.fillColor = fillColor;
    }

    public int area() {
        return this.width * this.height;
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.point.getX(), this.point.getY()), this.width, this.height);
    }

    public boolean isOverlapping(Rectangle other) {
        Point topLeft = new Point(this.point.getX(), this.point.getY());
        Point bottomRight = new Point(this.point.getX() + this.width, this.point.getY() + this.height);
        Point otherTopLeft = new Point(other.point.getX(), other.point.getY());
        Point otherBottomRight = new Point(other.point.getX() + other.width, other.point.getY() + other.height);
        return (topLeft.getX() > otherBottomRight.getX() || otherTopLeft.getX() > bottomRight.getX()) || (bottomRight.getY() < otherTopLeft.getY() || otherBottomRight.getY() < topLeft.getY()) ? false : true;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
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

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.fillColor);
        graphicsContext.fillRect(this.point.getX(), this.point.getY(), this.width, this.height);
    }
}
