package at.fhhgb.mtd.gop.at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class CircleFeature implements NamedFeature {
    private Circle currentCircle;
    private int originX;
    private int originY;
    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public void onSelect() {
    }

    @Override
    public void onDeselect() {

    }

    @Override
    public void onMouseClick(int i, int i1) {

    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
