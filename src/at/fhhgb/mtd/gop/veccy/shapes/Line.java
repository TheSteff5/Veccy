package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line implements DrawableShape{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

    public int area(){
        return 0;
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.x1 > this.x2 ? this.x2 : this.x1, this.y1 > this.y2 ? this.y2 : this.y1), Math.abs(this.x2-this.x1), Math.abs(this.y2-this.y1));
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(Color.RED);
        graphicsContext.strokeLine(this.x1, this.y1, this.x2, this.y2);
    }
}
