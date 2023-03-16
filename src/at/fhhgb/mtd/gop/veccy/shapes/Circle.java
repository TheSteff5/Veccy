package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle implements DrawableShape {

    private Point point;
    private int radius;
    private Color fillColor;

    public Circle(Point point, int radius) {
        this.point = point;
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
        return new Rectangle(new Point(this.point.getX() - this.radius, this.point.getY() - this.radius), this.radius * 2, this.radius * 2);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return fillColor;
    }

    public void setColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.fillColor);
        graphicsContext.fillOval(this.point.getX() - radius, this.point.getY() - radius, this.radius * 2, this.radius * 2);
    }
}
