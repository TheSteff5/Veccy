import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class Main {
    public static void main(String[] args) {

        Vector3 vec = new Vector3(new double[]{5.0, 5.0, 1.0});
        Matrix3 translation = TransformFactory.createTranslation(2, 3);
        Vector3 transformedVec = translation.mult(vec);

        for(int i = 0; i <3; i++){
            System.out.println(transformedVec.getValues()[i]);
        }
    }
}