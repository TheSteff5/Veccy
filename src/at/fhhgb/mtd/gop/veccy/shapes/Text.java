package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Text extends Shape {

    private String text;

    public Text(int x, int y, String text) {
        super(x, y);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public double[][] getCoordinates() {
        return new double[0][];
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillText(this.text, this.getX(), this.getY());
        graphicsContext.strokeText(this.text, this.getX(), this.getY());
    }

}
