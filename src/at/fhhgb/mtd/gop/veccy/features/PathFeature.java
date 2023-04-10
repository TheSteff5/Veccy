package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Path;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;

import java.util.LinkedList;

public class PathFeature implements NamedFeature {
    private CanvasModel model;
    private Path currentPath;
    private PolygonFeature polygonFeature;
    private int originX;
    private int originY;
    private boolean isSelected;

    public PathFeature(CanvasModel model, PolygonFeature polygonFeature) {
        this.model = model;
        this.polygonFeature = polygonFeature;
    }

    @Override
    public String getName() {
        return "Path";
    }

    @Override
    public void onSelect() {
        this.isSelected = true;
    }

    @Override
    public void onDeselect() {
        this.isSelected = false;
        this.polygonFeature.setCurrentPolygon(new Polygon(this.currentPath.getPathCoordinates()));
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.isSelected) {
            this.originX = i;
            this.originY = i1;

            if (this.currentPath == null) {
                this.currentPath = new Path(this.originX, this.originY);
            } else {
                this.currentPath.addPathCoordinate(new Point(this.originX, this.originY));
            }

            this.currentPath.setFillColor(this.model.getCurrentFillColor());
            this.currentPath.setStrokeColor(this.model.getCurrentStrokeColor());
            this.model.addShape(currentPath);
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
    }
}
