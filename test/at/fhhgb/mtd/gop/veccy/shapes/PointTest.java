package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void testArea() {
        Point p = new Point(1,2);
        assertEquals( 0,p.area());
        assertNotEquals(100, p.area());

        Point p2 = new Point(3,2);
        assertEquals( 0,p2.area());
        assertNotEquals(50, p2.area());
    }

    @Test
    void testBoundingBox() {
        Point p = new Point(1,2);
        assertEquals( 1, p.boundingBox().getPoint().getX());
        assertEquals( 2, p.boundingBox().getPoint().getY());
        assertEquals( 1, p.boundingBox().getWidth());
        assertEquals( 1, p.boundingBox().getHeight());

        Point p2 = new Point(0,0);
        assertEquals( 0, p2.boundingBox().getPoint().getX());
        assertEquals( 0, p2.boundingBox().getPoint().getY());
        assertEquals( 1, p2.boundingBox().getWidth());
        assertEquals( 1, p2.boundingBox().getHeight());
    }
}