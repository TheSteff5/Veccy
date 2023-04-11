package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;

public class Path extends Shape {
    LinkedList<Vector3> pathCoordinates = new LinkedList<>();

    public Path(int x, int y) {
        super(x, y);
        this.addPathCoordinate(new Point(x, y));
    }

    private double[][] getCoordinates() {
        double[][] coordinates = new double[2][pathCoordinates.size()];
        for (int i = 0; i < pathCoordinates.size(); i++) {
            coordinates[0][i] = pathCoordinates.get(i).getValues()[0];
            coordinates[1][i] = pathCoordinates.get(i).getValues()[1];
        }

        return coordinates;
    }

    public void addPathCoordinate(Point point) {
        this.pathCoordinates.add(new Vector3(new double[]{point.getX(), point.getY(), 1}));
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = this.getCoordinates();
        graphicsContext.strokePolyline(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
