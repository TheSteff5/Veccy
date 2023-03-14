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
        for(int x=0; x < values.length; x++){
            for(int y = 0; y < values[x].length; y++){
                this.values[x][y] = values[x][y];
            }
        }
    }

    public Matrix3(Matrix3 matrix) {
        this(matrix.getValues());
    }

    public Matrix3 mult(Matrix3 matrix) {
        return new Matrix3();
    }

    public Vector3 mult(Vector3 vector) {
        return new Vector3();
    }

    public double[][] getValues() {
        return this.values;
    }


}
