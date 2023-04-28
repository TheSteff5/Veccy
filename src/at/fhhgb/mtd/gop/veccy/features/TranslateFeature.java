package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;

import java.util.LinkedList;

public class TranslateFeature implements NamedFeature {
    CanvasModel model;
    LinkedList<Shape> shape;
    private boolean isSelected = false;
    private boolean isDragging = false;
    private int previousX = 0;
    private int previousY = 0;

    public TranslateFeature(CanvasModel model, LinkedList<Shape> shape) {
        this.model = model;
        this.shape = shape;
    }

    @Override
    public String getName() {
        return "Translate";
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
        isDragging = false;
        this.previousX = i;
        this.previousY = i1;

    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.isSelected) {
            Shape shape = this.shape.get(model.getCurrentlySelectedShapeIndex());
            if (!isDragging) {
                isDragging = true;
            } else {
                int deltaX = i - previousX;
                int deltaY = i1 - previousY;
                shape.setX(shape.getX() + deltaX);
                shape.setY(shape.getY() + deltaY);
            }

            previousX = i;
            previousY = i1;
        }
    }
}
