package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.features.*;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.TransformConfig;
import at.fhhgb.mtd.gop.veccy.shapes.*;
import at.fhhgb.mtd.gop.veccy.view.BlockingTransformInputDialog;
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
        TranslateFeature translateF = new TranslateFeature(model, shapes);
        RotateFeature rotateF = new RotateFeature(model, shapes);
        TransformFeature transformF = new TransformFeature(model, shapes);

        model.addFeature(rectangleF);
        model.addFeature(circleF);
        model.addFeature(lineF);
        model.addFeature(pointF);
        model.addFeature(polygonF);
        model.addFeature(pathF);
        model.addFeature(textF);
        model.addFeature(translateF);
        model.addFeature(rotateF);
        model.addFeature(transformF);


        Rectangle r1 = new Rectangle(new Point(30, 30), 100, 100);
        shapes.add(r1);
        model.addShape(r1);
        Circle c1 = new Circle(new Point(500, 500), 30);
        shapes.add(c1);
        model.addShape(c1);
        model.setShapeCreationHandler(s -> {
            shapes.add((Shape)s);

            //if(s)

   //         model.addShape(s) ;
        });

        

        model.setCurrentlySelectedShapeHandler(n -> {
            for (Shape shape : shapes) {
                shape.setSelected(false);
            }
            shapes.get(n).setSelected(true);
        });

        model.setShapeDeletionHandler(n -> {
            System.out.println("Deleted" + n);
            model.removeShape(shapes.get(n));
            shapes.remove(shapes.get(n));

        });


        // rotation test


    }
}