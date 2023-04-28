package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;

import java.util.LinkedList;

public class RotateFeature implements NamedFeature {
    CanvasModel model;
    LinkedList<Shape> shape;
    private boolean isSelected = false;
    private boolean isDragging = false;
    private int previousX = 0;
    private int previousY = 0;

    public RotateFeature(CanvasModel model, LinkedList<Shape> shape) {
        this.model = model;
        this.shape = shape;
    }

    @Override
    public String getName() {
        return "Rotate";
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
        this.previousX = 0;
        this.previousY = 0;

    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.isSelected) {
            Shape shape = this.shape.get(model.getCurrentlySelectedShapeIndex());
            if (!isDragging) {
                isDragging = true;
            } else {
                int deltaX = i - shape.getX();
                int deltaY = i1 - shape.getY();;
                double angle = Math.atan2(deltaY, deltaX);
                Matrix3 rotation = TransformFactory.createRotation(angle);
                shape.setTransform(rotation);
            }

            previousX = i;
            previousY = i1;
        }
    }
}
