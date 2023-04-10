package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;

public class Polygon extends Shape {
    LinkedList<Vector3> coordinates = new LinkedList<>();

    public Polygon(LinkedList<Vector3> coordinates) {
        super((int) coordinates.get(0).getValues()[0], (int) coordinates.get(0).getValues()[1]);
        this.coordinates = coordinates;
    }

    private double[][] getCoordinates() {
        double[][] coordinates = new double[2][this.coordinates.size()];

        for (int i = 0; i < this.coordinates.size(); i++) {
            coordinates[0][i] = this.coordinates.get(i).getValues()[0];
            coordinates[1][i] = this.coordinates.get(i).getValues()[1];
        }

        return coordinates;
    }

    public LinkedList<Vector3> getLinkedListCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(LinkedList<Vector3> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = this.getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
