package at.fhhgb.mtd.gop.math;

import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3Test {
    // Info: Discussed with the professor, the test of the multiplication method should be enough
    @Test
    void testMatrixMult() {
        double[][] matrix1 = {
                {1.0, 2.0, 1.0},
                {2.0, 1.0, 2.0},
                {1.0, 2.0, 1.0}
        };

        double[][] matrix2 = {
                {1.0, 1.0, 1.0},
                {2.0, 2.0, 2.0},
                {3.0, 3.0, 3.0}
        };

        double[][] matrix3 = {
                {2.0, 2.0, 2.0},
                {1.0, 3.0, 4.0},
                {4.0, 1.0, 2.0}
        };

        double[][] matrixSolution = {
                {8.0, 8.0, 8.0},
                {10.0, 10.0, 10.0},
                {8.0, 8.0, 8.0}
        };

        Matrix3 first_m3 = new Matrix3(matrix1);
        Matrix3 second_m3 = new Matrix3(matrix2);

        // multiplication with Matrix and Matrix
        assertTrue(Arrays.deepEquals(first_m3.mult(second_m3).getValues(), matrixSolution));


        double[] vector = {1.0, 1.0, 1.0};
        double[] vectorSolution = {6.0, 8.0, 7.0};
        Matrix3 third_m3 = new Matrix3(matrix3);
        Vector3 v3 = new Vector3(vector);

        // multiplication with Matrix and Vector
        assertTrue(Arrays.equals(third_m3.mult(v3).getValues(), vectorSolution));
    }
}