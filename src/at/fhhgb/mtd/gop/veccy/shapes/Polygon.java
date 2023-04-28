package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
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
        LinkedList<Vector3> tmpList = new LinkedList<>(this.polygonCoordinates);


        Matrix3 translateOrigin = TransformFactory.createTranslation(this.getX(), this.getY());
        Matrix3 inverseTranslate = TransformFactory.createTranslation(-this.getX(), -this.getY());

        if (this.transform != null) {
            for (int i = 0; i < this.polygonCoordinates.size(); i++) {
                tmpList.set(i, translateOrigin.mult(this.transform).mult(inverseTranslate).mult(this.polygonCoordinates.get(i)));
            }
        }

        double[][] coordinates = new double[2][tmpList.size()];
        for (int i = 0; i < tmpList.size(); i++) {
            coordinates[0][i] = tmpList.get(i).getValues()[0];
            coordinates[1][i] = tmpList.get(i).getValues()[1];
        }

        return coordinates;
    }

    public void addPolygonCoordinate(Point point) {
        this.polygonCoordinates.add(new Vector3(new double[]{point.getX(), point.getY(), 1}));
    }

    @Override
    public void setX(int x){
        if(polygonCoordinates.size() > 0){
            int deltaX = x - getX();
            for(Vector3 polygonCoordinate : polygonCoordinates) {
                polygonCoordinate.getValues()[0] += deltaX;
            }
        }
    }

    @Override
    public void setY(int y){
        if(polygonCoordinates.size() > 0){
            int deltaY = y - getY();
            for(Vector3 polygonCoordinate : polygonCoordinates) {
                polygonCoordinate.getValues()[1] += deltaY;
            }
        }
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = this.getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
