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
        TextFeature textF = new TextFeature(model);

        model.addFeature(rectangleF);
        model.addFeature(circleF);
        model.addFeature(lineF);
        model.addFeature(pointF);
        model.addFeature(polygonF);
        model.addFeature(pathF);
        model.addFeature(textF);

        // rotation test
        Rectangle r1 = new Rectangle(new Point(30, 30), 100, 100);
        Rectangle r2 = new Rectangle(new Point(30, 30), 100, 100);
        r2.setFillColor(Color.RED);
        r1.setTransform(TransformFactory.createRotation(Math.PI / 4));
        model.addShape(r1);
        model.addShape(r2);

        // translation test
        Rectangle r3 = new Rectangle(new Point(10, 10), 100, 100);
        r3.setTransform(TransformFactory.createTranslation(500, 500));
        model.addShape(r3);

        // vertical mirror test
        Rectangle r4 = new Rectangle(new Point(300, 50), 200, 100);
        r4.setFillColor(Color.RED);
        r4.setTransform(TransformFactory.createRotation((Math.PI / 180) * 20));
        r4.setTransform(TransformFactory.createVerticalMirroring());
        model.addShape(r4);

        Rectangle r5 = new Rectangle(new Point(300, 50), 200, 100);
        r5.setTransform(TransformFactory.createRotation((Math.PI / 180) * 20));
        model.addShape(r5);

        // horizontal mirror test
        Rectangle r6 = new Rectangle(new Point(300, 300), 200, 100);
        r6.setFillColor(Color.RED);
        r6.setTransform(TransformFactory.createRotation((Math.PI / 180) * 20));
        r6.setTransform(TransformFactory.createHorizontalMirroring());
        model.addShape(r6);

        Rectangle r7 = new Rectangle(new Point(300, 300), 200, 100);
        r7.setTransform(TransformFactory.createRotation((Math.PI / 180) * 20));
        model.addShape(r7);

        // circle
        Circle c1 = new Circle(new Point(700, 100), 100);
        model.addShape(c1);
    }
}