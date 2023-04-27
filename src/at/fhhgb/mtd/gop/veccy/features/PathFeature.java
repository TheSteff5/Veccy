package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Path;
import at.fhhgb.mtd.gop.veccy.shapes.Point;

public class PathFeature implements NamedFeature {
    private CanvasModel model;
    private Path currentPath;
    private int originX;
    private int originY;
    private boolean isSelected;

    public PathFeature(CanvasModel model) {
        this.model = model;
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
        this.currentPath = null;
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.isSelected) {
            this.originX = i;
            this.originY = i1;

            if (this.currentPath == null) {
                this.currentPath = new Path(this.originX, this.originY);
                this.model.addShape(currentPath);
            } else {
                this.currentPath.addPathCoordinate(new Point(this.originX, this.originY));
            }
            this.currentPath.setStrokeColor(this.model.getCurrentStrokeColor());
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
    }
}
