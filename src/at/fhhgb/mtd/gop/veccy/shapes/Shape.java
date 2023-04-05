package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Shape implements DrawableShape {
    protected Vector3 position;
    protected Matrix3 transform;
    protected Color fillColor = Color.WHITE;
    protected Color strokeColor = Color.WHITE;

    public Shape(int x, int y) {
        this.position = new Vector3(new double[]{x, y, 1.0});
    }

    // Returniert die x Koordinate von 'position'
    public int getX() {
        return (int) this.position.getValues()[0];
    }

    // Returniert die y Koordinate von 'position'
    public int getY() {
        return (int) this.position.getValues()[1];
    }

    // Setzt die 'fillColor' Instanzvariable
    public void setFillColor(Color c) {
        this.fillColor = c;
    }

    // Setzt die 'strokeColor' Instanzvariable
    public void setStrokeColor(Color c) {
        this.strokeColor = c;
    }

    // Setzt die 'transform' Instanzvariable
    public void setTransform(Matrix3 transform) {
        this.transform = transform;
    }

    // Setzt die fillColor und strokeColor am ‚graphicsContext‘
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.fillColor);
        graphicsContext.setStroke(this.strokeColor);
    }
}
