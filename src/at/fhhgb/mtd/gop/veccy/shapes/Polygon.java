package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;

public class Polygon extends Shape {
    LinkedList<Vector3> polygonCoordinates = new LinkedList<>();

    public Polygon(int x, int y) {
        super(x, y);
        this.addPolygonCoordinate(new Point(x, y));
    }

    public double[][] getCoordinates() {

        double[][] coordinates = new double[2][polygonCoordinates.size()];
        for (int i = 0; i < polygonCoordinates.size(); i++) {
            coordinates[0][i] = polygonCoordinates.get(i).getValues()[0];
            coordinates[1][i] = polygonCoordinates.get(i).getValues()[1];
        }

        return coordinates;
    }

    public void addPolygonCoordinate(Point point) {
        this.polygonCoordinates.add(new Vector3(new double[]{point.getX(), point.getY(), 1}));
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = this.getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
