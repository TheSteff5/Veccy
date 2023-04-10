package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Text;

public class TextFeature implements NamedFeature {
    private CanvasModel model;
    private Text currentText;
    private int originX;
    private int originY;
    private boolean isSelected;

    public TextFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Text";
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
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
    }
}
