import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class Main {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(new Point(1,1),10, 10);
        Rectangle r2 = new Rectangle(new Point(5,5), 10,10);

        System.out.println(r1.isOverlapping(r2));


    }
}