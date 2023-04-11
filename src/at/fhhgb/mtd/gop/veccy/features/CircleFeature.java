package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Point;

public class CircleFeature implements NamedFeature {
    private CanvasModel model;
    private Circle currentCircle;
    private int originX;
    private int originY;
    private boolean isSelected;

    public CircleFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Circle";
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
            if (currentCircle != null) {
                currentCircle = null;
            }
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.isSelected) {
            if (currentCircle == null) {
                this.originX = i;
                this.originY = i1;

                Circle circle = new Circle(new Point(this.originX, this.originY), 0, this.model.getCurrentFillColor());
                this.currentCircle = circle;
                this.model.addShape(currentCircle);

            } else {
                this.currentCircle.setRadius(i - this.originX);
            }
        }
    }
}
