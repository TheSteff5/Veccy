package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
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
        return new double[][] {{getX(), getX() + text.length() * 6},
                {getY(), getY() - 12}};
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = this.getCoordinates();
        graphicsContext.fillText(this.text, this.getX(), this.getY());
        graphicsContext.strokeText(this.text, this.getX(), this.getY());
    }

}
