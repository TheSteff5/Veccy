package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillOval(this.getX(), this.getY(), 4, 4);
        graphicsContext.strokeOval(this.getX(), this.getY(), 4, 4);
    }

}
