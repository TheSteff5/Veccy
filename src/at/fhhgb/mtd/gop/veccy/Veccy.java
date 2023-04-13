package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.features.*;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.*;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Veccy extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        LinkedList<Shape> shapes = new LinkedList<>();


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
        Rectangle r1 = new Rectangle(new Point(30, 30), 100, 100);
        shapes.add(r1);
        model.addShape(r1);
        model.setShapeCreationHandler(shape -> {


        });

        //model.setCurrentlySelectedShapeHandler();
        model.setCurrentlySelectedShapeHandler(n -> {
            System.out.println("Hello World");
            System.out.println(n);
        });


        // rotation test




    }
}