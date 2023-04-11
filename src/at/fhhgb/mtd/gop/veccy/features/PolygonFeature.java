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
        this.currentPolygon = null;
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.isSelected) {
            this.originX = i;
            this.originY = i1;

            if (this.currentPolygon == null) {
                this.currentPolygon = new Polygon(this.originX, this.originY);
            } else {
                this.currentPolygon.addPolygonCoordinate(new Point(this.originX, this.originY));
            }

            this.currentPolygon.setFillColor(this.model.getCurrentFillColor());
            this.currentPolygon.setStrokeColor(this.model.getCurrentStrokeColor());
            this.model.addShape(this.currentPolygon);
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
    }
}
