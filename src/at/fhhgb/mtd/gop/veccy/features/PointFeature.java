package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class PointFeature implements NamedFeature {
    private CanvasModel model;
    private Point currentPoint;
    private int originX;
    private int originY;
    private boolean isSelected;

    public PointFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Point";
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
            this.originX = i;
            this.originY = i1;

            Point point = new Point(this.originX, this.originY);
            this.currentPoint = point;
            this.currentPoint.setFillColor(this.model.getCurrentFillColor());
            this.currentPoint.setStrokeColor(this.model.getCurrentStrokeColor());
            this.model.addShape(currentPoint);
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.isSelected) {
            if (currentPoint != null) {
                Point point = new Point(i, i1);
                this.currentPoint = point;
                this.currentPoint.setFillColor(this.model.getCurrentFillColor());
                this.currentPoint.setStrokeColor(this.model.getCurrentStrokeColor());
                this.model.addShape(point);
            }
        }
    }
}
