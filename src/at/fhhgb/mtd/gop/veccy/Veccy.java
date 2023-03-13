package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
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

        double y;
        Rectangle[] sinus1 = new Rectangle[2000];
        Rectangle[] sinus2 = new Rectangle[2000];
        Line[] lines = new Line[2000];
        for(int x=0; x < 2000; x++){
            y =  stage.getHeight()/4 + 100 * Math.sin((x * (Math.PI/180)) - Math.PI);
            sinus1[x] = new Rectangle(new Point(x,(int)y),2,2);
            model.addShape(sinus1[x]);
        }

        for(int x=0; x < 2000; x++){
            y = (stage.getHeight() - stage.getHeight()/4) + 100 * Math.sin((x * (Math.PI/180)) );
            sinus2[x] = new Rectangle(new Point(x,(int)y),2,2);
            model.addShape(sinus2[x]);
        }


        for(int x=0; x < lines.length; x+=4){


            lines[x] = new Line(sinus1[x].getPoint().getX(), sinus1[x].getPoint().getY(), sinus2[x].getPoint().getX(), sinus2[x].getPoint().getY());
            model.addShape(lines[x]);
        }



        //Rectangle r1 = new Rectangle(new Point(1,1),10,10);




    }
}