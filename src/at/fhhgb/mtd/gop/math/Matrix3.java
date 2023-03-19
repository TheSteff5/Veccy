package at.fhhgb.mtd.gop.math;

public class Matrix3 {
    private double[][] values;

    public Matrix3() {
        this.values = new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
    }

    public Matrix3(double[][] values) {
        this.values = new double[values.length][values[0].length];
        for (int x = 0; x < values.length; x++) {
            for (int y = 0; y < values[x].length; y++) {
                this.values[x][y] = values[x][y];
            }
        }
    }

    public Matrix3(Matrix3 matrix) {
        this(matrix.getValues());
    }

    public Matrix3 mult(Matrix3 matrix) {
        double[][] newMatrixValues = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    newMatrixValues[i][j] += this.values[i][k] * matrix.getValues()[k][j];
                }
            }
        }
        return new Matrix3(newMatrixValues);
    }

    public Vector3 mult(Vector3 vector) {
        double[] newVectorValues = new double[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newVectorValues[i] += this.values[i][j] * vector.getValues()[j];
            }
        }
        return new Vector3(newVectorValues);
    }

    public double[][] getValues() {
        return this.values;
    }


}
