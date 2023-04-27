package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements DrawableShape {
    private boolean isSelected = false;
    protected Vector3 position;
    protected Matrix3 transform;
    protected Color fillColor = Color.WHITE;
    protected Color strokeColor = Color.WHITE;

    public Shape(int x, int y) {
        this.position = new Vector3(new double[]{x, y, 1.0});
    }

    public void setX(int x) {
        this.position.getValues()[0] = x;
    }

    // Returniert die x Koordinate von 'position'
    public int getX() {
        return (int) this.position.getValues()[0];
    }

    public void setY(int y) {
        this.position.getValues()[1] = y;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract double[][] getCoordinates();

    public Rectangle getBoundingBox() {
        double minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        double minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        for (int i = 0; i < this.getCoordinates()[0].length; i++) {
            if (this.getCoordinates()[0][i] > maxX) {
                maxX = this.getCoordinates()[0][i];
            }

            if (this.getCoordinates()[0][i] < minX) {
                minX = this.getCoordinates()[0][i];
            }
        }

        for (int i = 0; i < this.getCoordinates()[1].length; i++) {
            if (this.getCoordinates()[1][i] > maxY) {
                maxY = this.getCoordinates()[1][i];
            }

            if (this.getCoordinates()[1][i] < minY) {
                minY = this.getCoordinates()[1][i];
            }
        }

        // is a spacing around the object, so you can see the boundingBox better
        minX= minX-2;
        minY= minY-2;
        maxX = maxX+2;
        maxY = maxY+2;

        return new Rectangle(new Point((int) minX, (int) minY), (int)(maxX - minX), (int)(maxY - minY));

    }

    // Setzt die fillColor und strokeColor am ‚graphicsContext‘
    @Override
    public void draw(GraphicsContext graphicsContext) {
        // Zeichne eine Bounding Box, sofern das Shape selektiert ist
        if (isSelected()) {
            Rectangle bb = this.getBoundingBox();
            graphicsContext.setStroke(Color.RED);
            graphicsContext.strokeRect(bb.getX(), bb.getY(),
                    bb.getWidth(), bb.getHeight());
        }
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);
    }
}
