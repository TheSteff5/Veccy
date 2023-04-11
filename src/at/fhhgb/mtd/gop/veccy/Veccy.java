package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.features.*;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
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
        CircleFeature circleF = new CircleFeature(model);
        LineFeature lineF = new LineFeature(model);
        PointFeature pointF = new PointFeature(model);
        PolygonFeature polygonF = new PolygonFeature(model);
        PathFeature pathF = new PathFeature(model);

        model.addFeature(rectangleF);
        model.addFeature(circleF);
        model.addFeature(lineF);
        model.addFeature(pointF);
        model.addFeature(polygonF);
        model.addFeature(pathF);

      /*  Rectangle r1 = new Rectangle(new Point(10, 10), 100, 100);
        Rectangle r2 = new Rectangle(new Point(60-5, 60-5), 10, 10);
        r2.setFillColor(Color.RED);
        r1.setTransform(TransformFactory.createRotation(Math.PI / 4));
        model.addShape(r1);
        model.addShape(r2);*/

        Circle c1 = new Circle(new Point(500, 500), 200);
        Circle c2 = new Circle(new Point(500, 500), 200);
        model.addShape(c2);
        c2.setFillColor(Color.RED);
        c1.setTransform(TransformFactory.createRotation(22.5 * (Math.PI) / 180));
        model.addShape(c1);
    }
}