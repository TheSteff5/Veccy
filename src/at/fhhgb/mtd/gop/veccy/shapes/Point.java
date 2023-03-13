package at.fhhgb.mtd.gop.veccy.shapes;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int area(){
        return 0;
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.x, this.y), 1, 1);
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY() {
        return this.y;
    }


}
