package at.fhhgb.mtd.gop.math;

public class TransformFactory {
    public static Matrix3 createTranslation(int deltaX, int deltaY) {
        double[][] translationMatrix = new double[][]{
                {1, 0, deltaX},
                {0, 1, deltaY},
                {0, 0, 1}
        };
        return new Matrix3(translationMatrix);
    }

    public static Matrix3 createRotation(double radians) {
        double[][] rotationMatrix = new double[][]{
                {Math.cos(radians), -1 * Math.sin(radians), 0},
                {Math.sin(radians), Math.cos(radians), 0},
                {0, 0, 1}
        };
        return new Matrix3(rotationMatrix);
    }

    public static Matrix3 createHorizontalMirroring() {
        double[][] horizontalMirroringMatrix = new double[][]{
                {-1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        return new Matrix3(horizontalMirroringMatrix);
    }

    public static Matrix3 createVerticalMirroring() {
        double[][] verticalMirroringMatrix = new double[][]{
                {1, 0, 0},
                {0, -1, 0},
                {0, 0, 1}
        };
        return new Matrix3(verticalMirroringMatrix);
    }

    public static Matrix3 createScaling(double factorX, double factorY) {
        double[][] scalingMatrix = new double[][]{
                {factorX, 0, 0},
                {0, factorY, 0},
                {0, 0, 1}
        };
        return new Matrix3(scalingMatrix);
    }
}
