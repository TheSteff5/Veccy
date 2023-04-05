package at.fhhgb.mtd.gop.veccy.shapes;

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

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillOval(this.getX() - radius, this.getY() - radius, this.radius * 2, this.radius * 2);
        graphicsContext.strokeOval(this.getX() - radius, this.getY() - radius, this.radius * 2, this.radius * 2);
    }
}
