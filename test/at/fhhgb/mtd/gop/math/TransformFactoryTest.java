package at.fhhgb.mtd.gop.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


class TransformFactoryTest {
    @Test
    void testCreateTranslation() {
        Vector3 vec = new Vector3(new double[]{5.0, 5.0, 1.0});
        Matrix3 translation = TransformFactory.createTranslation(2, 3);
        Vector3 transformedVec = translation.mult(vec);
        assertTrue(Arrays.equals(transformedVec.getValues(), new double[]{7.0, 8.0, 1.0}));
    }

    @Test
    void testCreateRotation() {
        Vector3 vec = new Vector3(new double[]{5.0, 5.0, 1.0});
        Matrix3 rotation = TransformFactory.createRotation(Math.PI / 2);
        Vector3 rotatedVec = rotation.mult(vec);
        assertTrue(Arrays.equals(rotatedVec.getValues(), new double[]{-5.0, 5.0, 1.0}));
    }

    @Test
    void testCreateHorizontalMirroring() {
        Vector3 vec = new Vector3(new double[]{5.0, 5.0, 1.0});
        Matrix3 horizontalMirroring = TransformFactory.createHorizontalMirroring();
        Vector3 mirroredVec = horizontalMirroring.mult(vec);
        assertTrue(Arrays.equals(mirroredVec.getValues(), new double[]{-5.0, 5.0, 1.0}));
    }

    @Test
    void testCreateVerticalMirroring() {
        Vector3 vec = new Vector3(new double[]{5.0, 5.0, 1.0});
        Matrix3 verticalMirroring = TransformFactory.createVerticalMirroring();
        Vector3 mirroredVec = verticalMirroring.mult(vec);
        assertTrue(Arrays.equals(mirroredVec.getValues(), new double[]{5.0, -5.0, 1.0}));
    }

    @Test
    void testCreateScaling() {
        Vector3 vec = new Vector3(new double[]{5.0, 5.0, 1.0});
        Matrix3 scaling = TransformFactory.createScaling(2, 2);
        Vector3 scaledVec = scaling.mult(vec);
        assertTrue(Arrays.equals(scaledVec.getValues(), new double[]{10.0, 10.0, 1.0}));

        scaling = TransformFactory.createScaling(3, 1.5);
        scaledVec = scaling.mult(vec);
        assertTrue(Arrays.equals(scaledVec.getValues(), new double[]{15.0, 7.5, 1.0}));
    }
}