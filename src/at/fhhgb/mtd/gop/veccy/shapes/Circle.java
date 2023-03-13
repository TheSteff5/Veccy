package at.fhhgb.mtd.gop.veccy.shapes;

public class Circle {

    private Point point;
    private int radius;

    public Circle(Point point, int radius){
        this.point = point;
        this.radius = radius;
    }

    public int area(){
        return (int)(Math.PI * (this.radius*this.radius));
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.point.getX()-this.radius, this.point.getY()-this.radius), this.radius*2, this.radius*2);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
