package at.fhhgb.mtd.gop.veccy.features;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Line;

public class LineFeature implements NamedFeature {
    private CanvasModel model;
    private Line currentLine;
    private int originX;
    private int originY;
    private boolean isSelected;

    public LineFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Line";
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
            if (currentLine != null) {
                currentLine = null;
            }
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.isSelected) {
            if (currentLine == null) {
                this.originX = i;
                this.originY = i1;
                Line line = new Line(this.originX, this.originY, 0, 0);
                line.setFillColor(this.model.getCurrentFillColor());
                line.setStrokeColor(this.model.getCurrentStrokeColor());
                this.currentLine = line;
            } else {
                this.currentLine.setX2(i);
                this.currentLine.setY2(i1);
                this.model.addShape(this.currentLine);
            }
        }
    }
}
