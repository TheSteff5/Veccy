package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point implements DrawableShape {
    private int x;
    private int y;
    private Color fillColor;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, Color fillColor) {
        this(x, y);
        this.fillColor = fillColor;
    }

    public int area() {
        return 0;
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.x, this.y), 1, 1);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
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
        graphicsContext.fillOval(this.x, this.y, 1, 1);
    }

}
