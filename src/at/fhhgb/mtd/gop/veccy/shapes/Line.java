package at.fhhgb.mtd.gop.veccy.shapes;

public class Line {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

    public int area(){
        return 0;
    }

    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.x1 > this.x2 ? this.x2 : this.x1, this.y1 > this.y2 ? this.y2 : this.y1), Math.abs(this.x2-this.x1), Math.abs(this.y2-this.y1));
    }
}
