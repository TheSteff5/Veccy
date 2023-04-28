package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.model.TransformConfig;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;
import at.fhhgb.mtd.gop.veccy.view.BlockingTransformInputDialog;

import java.util.LinkedList;

public class TransformFeature implements NamedFeature {
    CanvasModel model;
    LinkedList<Shape> shape;

    public TransformFeature(CanvasModel model, LinkedList<Shape> shape) {
        this.model = model;
        this.shape = shape;
    }

    @Override
    public String getName() {
        return "Transform";
    }

    @Override
    public void onSelect() {
        Shape shape = this.shape.get(model.getCurrentlySelectedShapeIndex());
        TransformConfig config = BlockingTransformInputDialog.requestConfigInput();

        Matrix3 scale = TransformFactory.createScaling(config.getScaleX(), config.getScaleY());
        Matrix3 rotate = TransformFactory.createRotation(config.getRotation());
        Matrix3 mirrorX = TransformFactory.createHorizontalMirroring();
        Matrix3 mirrorY = TransformFactory.createVerticalMirroring();
        Matrix3 transform = scale.mult(rotate.mult(mirrorX.mult(mirrorY)));
        shape.setTransform(transform);
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
