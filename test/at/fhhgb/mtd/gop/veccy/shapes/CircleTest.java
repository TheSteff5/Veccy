package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void testArea() {
        Circle circle = new Circle(new Point(0, 0), 5);
        assertEquals(78, circle.area());
        assertNotEquals(100, circle.area());

        Circle circle2 = new Circle(new Point(5, 5), 10);
        assertEquals(314, circle2.area());
        assertNotEquals(100, circle2.area());

    }

    @Test
    void testBoundingBox() {
        Circle circle = new Circle(new Point(10, 10), 5);
        assertEquals(5, circle.boundingBox().getX());
        assertEquals(5, circle.boundingBox().getY());
        assertEquals(10, circle.boundingBox().getWidth());
        assertEquals(10, circle.boundingBox().getHeight());

        Circle circle2 = new Circle(new Point(5, 5), 10);
        assertEquals(-5, circle2.boundingBox().getX());
        assertEquals(-5, circle2.boundingBox().getY());
        assertEquals(20, circle2.boundingBox().getWidth());
        assertEquals(20, circle2.boundingBox().getHeight());
    }

}