package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.application.Application;
import javafx.stage.Stage;

public class Veccy extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();
        Rectangle r1 = new Rectangle(new Point(1,1),10,10);
        model.addShape(r1);

    }
}