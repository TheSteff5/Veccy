package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void testArea() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), 20, 20);
        assertEquals( 400, rectangle.area());
        assertNotEquals(100, rectangle.area());

        Rectangle rectangle2 = new Rectangle(new Point(4, 2), 5, 2);
        assertEquals( 10, rectangle2.area());
        assertNotEquals(100, rectangle2.area());
    }

    @Test
    void testBoundingBox() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), 20, 20);
        assertEquals( 0, rectangle.boundingBox().getPoint().getX());
        assertEquals( 0, rectangle.boundingBox().getPoint().getY());
        assertEquals( 20, rectangle.boundingBox().getWidth());
        assertEquals( 20, rectangle.boundingBox().getHeight());

        Rectangle rectangle2 = new Rectangle(new Point(5, 5), 25, 25);
        assertEquals( 5, rectangle2.boundingBox().getPoint().getX());
        assertEquals( 5, rectangle2.boundingBox().getPoint().getY());
        assertEquals( 25, rectangle2.boundingBox().getWidth());
        assertEquals( 25, rectangle2.boundingBox().getHeight());
    }

    @Test
    void testIsOverlapping() {
        Rectangle r = new Rectangle(new Point(10, 10), 10, 10);
        Rectangle r2 = new Rectangle(new Point(10, 5), 10, 4);
        Rectangle r3 = new Rectangle(new Point(2, 2), 2, 2);
        Rectangle r4 = new Rectangle(new Point(10, 21), 10, 4);
        Rectangle r5 = new Rectangle(new Point(21, 10), 4, 10);
        Rectangle r6 = new Rectangle(new Point(5, 5), 15, 15);
        assertTrue(r.isOverlapping(r)); // overlapping
        assertFalse(r.isOverlapping(r2)); // over from RectA
        assertFalse(r.isOverlapping(r3)); // left from rectA
        assertFalse(r.isOverlapping(r4)); // under from rectA
        assertFalse(r.isOverlapping(r5)); // right from rect A
        assertTrue(r.isOverlapping(r6)); // overlapping
    }
}