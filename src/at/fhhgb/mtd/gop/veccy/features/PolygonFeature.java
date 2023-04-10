package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Path;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

import java.util.LinkedList;

public class PolygonFeature implements NamedFeature {
    private CanvasModel model;
    private Polygon currentPolygon;
    private int originX;
    private int originY;
    private boolean isSelected;

    public PolygonFeature(CanvasModel model) {
        this.model = model;
    }

    public Polygon getCurrentPolygon() {
        return currentPolygon;
    }

    public void setCurrentPolygon(Polygon currentPolygon) {
        this.currentPolygon = currentPolygon;
    }

    @Override
    public String getName() {
        return "Polygon";
    }

    @Override
    public void onSelect() {
        this.isSelected = true;
    }

    @Override
    public void onDeselect() {
        this.isSelected = false;
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.isSelected) {
            if (currentPolygon != null) {
                this.originX = i;
                this.originY = i1;

                LinkedList<Vector3> newCoordinates = new LinkedList<>();

                for (int j = 0; j < this.currentPolygon.getLinkedListCoordinates().size(); j++) {

                    newCoordinates.add(TransformFactory.createTranslation((int) this.currentPolygon.getLinkedListCoordinates().get(j).getValues()[0], (int) this.currentPolygon.getLinkedListCoordinates().get(j).getValues()[1]).mult(new Vector3(new double[]{-i, -i1, 1})));
                }


                Polygon polygon = new Polygon(newCoordinates);
                this.currentPolygon = polygon;
                this.currentPolygon.setFillColor(this.model.getCurrentFillColor());
                this.currentPolygon.setStrokeColor(this.model.getCurrentStrokeColor());
                this.model.addShape(currentPolygon);
            }

        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.isSelected) {
            if (currentPolygon == null) {
                this.originX = i;
                this.originY = i1;

                LinkedList<Vector3> newCoordinates = new LinkedList<>();

                for (int j = 0; j < this.currentPolygon.getLinkedListCoordinates().size(); j++) {

                    newCoordinates.add(TransformFactory.createTranslation((int) this.currentPolygon.getLinkedListCoordinates().get(i).getValues()[0], (int) this.currentPolygon.getLinkedListCoordinates().get(i).getValues()[1]).mult(this.currentPolygon.getLinkedListCoordinates().get(i)));
                }


                Polygon polygon = new Polygon(newCoordinates);



              /*  Rectangle rectangle = new Rectangle(new Point(this.originX, this.originY), 0, 0);
                rectangle.setFillColor(this.model.getCurrentFillColor());
                rectangle.setStrokeColor(this.model.getCurrentStrokeColor());
                this.currentPolygon = rectangle;
                this.model.addShape(currentPolygon);*/

            } else {

     /*           this.currentPolygon.getCoordinates()

                this.currentPolygon.setWidth(i - this.originX);
                this.currentPolygon.setHeight(i1 - this.originY);*/
            }
        }
    }
}
