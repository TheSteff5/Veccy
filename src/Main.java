import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.Vector3;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class Main {
    public static void main(String[] args) {
        double[][] matrix1 = {
                {1, 2, 1},
                {2, 1, 2},
                {1, 2, 1}
        };

        double[][] matrix2 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        double[][] matrix3 = {
                {2, 2, 2},
                {1, 3, 4},
                {4, 1, 2}
        };


        double[] vector = {1, 1, 1};

        Matrix3 m3 = new Matrix3(matrix1);
        Matrix3 second_m3 = new Matrix3(matrix3);


        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(m3.mult(new Matrix3(matrix2)).getValues()[x][y] + " ");
            }
            System.out.println();
        }

        for (int x = 0; x < 3; x++) {
            System.out.println(second_m3.mult(new Vector3(vector)).getValues()[x]);

        }


    }
}