package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    void testArea() {
        Line l = new Line(10, 10, 20, 20);
        assertEquals(0, l.area());
        assertNotEquals(100, l.area());

        Line l2 = new Line(0, 0, 10, 10);
        assertEquals(0, l2.area());
        assertNotEquals(-100, l2.area());
    }

    @Test
    void testBoundingBox() {
        Line l = new Line(10, 10, 20, 20);
        assertEquals(10, l.boundingBox().getX());
        assertEquals(10, l.boundingBox().getY());
        assertEquals(10, l.boundingBox().getWidth());
        assertEquals(10, l.boundingBox().getHeight());

        Line l2 = new Line(20, 20, 10, 10);
        assertEquals(10, l2.boundingBox().getX());
        assertEquals(10, l2.boundingBox().getY());
        assertEquals(10, l2.boundingBox().getWidth());
        assertEquals(10, l2.boundingBox().getHeight());

        Line l3 = new Line(20, 10, 10, 20);
        assertEquals(10, l3.boundingBox().getX());
        assertEquals(10, l3.boundingBox().getY());
        assertEquals(10, l3.boundingBox().getWidth());
        assertEquals(10, l3.boundingBox().getHeight());

        Line l4 = new Line(10, 20, 20, 10);
        assertEquals(10, l4.boundingBox().getX());
        assertEquals(10, l4.boundingBox().getY());
        assertEquals(10, l4.boundingBox().getWidth());
        assertEquals(10, l4.boundingBox().getHeight());

        Line l5 = new Line(5, 3, 7, 3);
        assertEquals(5, l5.boundingBox().getX());
        assertEquals(3, l5.boundingBox().getY());
        assertEquals(2, l5.boundingBox().getWidth());
        assertEquals(0, l5.boundingBox().getHeight());
    }
}