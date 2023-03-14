package at.fhhgb.mtd.gop.math;

public class Vector3 {
    private double[] values;

    public Vector3() {
        this.values = new double[]{0, 0, 1};
    }

    public Vector3(double[] values) {
        this.values = new double[values.length];
        this.values[0] = values[0];
        this.values[1] = values[1];
        this.values[2] = values[2];
    }

    public Vector3(Vector3 vector) {
        this(vector.getValues());
    }

    public double[] getValues() {
        return this.values;
    }
}
