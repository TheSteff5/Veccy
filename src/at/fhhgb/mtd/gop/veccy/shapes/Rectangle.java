package at.fhhgb.mtd.gop.veccy.shapes;

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

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillRect(this.getX(), this.getY(), this.width, this.height);
        graphicsContext.strokeRect(this.getX(), this.getY(), this.width, this.height);
    }
}
