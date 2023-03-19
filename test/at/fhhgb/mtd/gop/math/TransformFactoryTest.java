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

    }

    @Test
    void testCreateHorizontalMirroring() {

    }

    @Test
    void testCreateVerticalMirroring() {

    }

    @Test
    void testCreateScaling() {

    }
}