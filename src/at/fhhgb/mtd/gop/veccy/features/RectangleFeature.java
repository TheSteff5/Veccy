package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.scene.paint.Color;

public class RectangleFeature implements NamedFeature {

    private CanvasModel model;
    private Rectangle currentRectangle;
    private int originX;
    private int originY;
    private boolean isSelected;

    public RectangleFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Rectangle";
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
            if (currentRectangle != null) {
                currentRectangle = null;
            }
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.isSelected) {
            if (currentRectangle == null) {
                this.originX = i;
                this.originY = i1;

                Rectangle rectangle = new Rectangle(new Point(this.originX, this.originY), 0, 0);
                rectangle.setFillColor(this.model.getCurrentFillColor());
                rectangle.setStrokeColor(this.model.getCurrentStrokeColor());
                this.currentRectangle = rectangle;
                this.model.addShape(currentRectangle);

            } else {
                this.currentRectangle.setWidth(i - this.originX);
                this.currentRectangle.setHeight(i1 - this.originY);
            }
        }
    }
}
