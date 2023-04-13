package at.fhhgb.mtd.gop.veccy.shapes;

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
        return new double[0][];
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
        graphicsContext.strokeLine(this.getX(), this.getY(), this.x2, this.y2);
    }
}
