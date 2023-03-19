package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.at.fhhgb.mtd.gop.veccy.features.CircleFeature;
import at.fhhgb.mtd.gop.at.fhhgb.mtd.gop.veccy.features.LineFeature;
import at.fhhgb.mtd.gop.at.fhhgb.mtd.gop.veccy.features.PointFeature;
import at.fhhgb.mtd.gop.at.fhhgb.mtd.gop.veccy.features.RectangleFeature;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Veccy extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        RectangleFeature rectangleF = new RectangleFeature(model);
        CircleFeature circleF = new CircleFeature();
        LineFeature lineF = new LineFeature();
        PointFeature pointF = new PointFeature();


        model.addFeature(rectangleF);
        model.addFeature(circleF);
        model.addFeature(lineF);
        model.addFeature(pointF);

        /*double y;
        Rectangle[] sinus1 = new Rectangle[2000];
        Rectangle[] sinus2 = new Rectangle[2000];
        for (int x = 0; x < 2000; x++) {
            y = stage.getHeight() / 4 + 100 * Math.sin((x * (Math.PI / 180)) - Math.PI);
            sinus1[x] = new Rectangle(new Point(x, (int) y), 2, 2, Color.YELLOW);
            model.addShape(sinus1[x]);
            y = (stage.getHeight() - stage.getHeight() / 4) + 100 * Math.sin((x * (Math.PI / 180)));
            sinus2[x] = new Rectangle(new Point(x, (int) y), 2, 2, Color.YELLOW);
            model.addShape(sinus2[x]);
        }

        for (int x = 0; x < 2000; x += 4) {
            model.addShape(new Line(sinus1[x].getPoint().getX(), sinus1[x].getPoint().getY(), sinus2[x].getPoint().getX(), sinus2[x].getPoint().getY(), Color.RED));
        }*/
    }
}