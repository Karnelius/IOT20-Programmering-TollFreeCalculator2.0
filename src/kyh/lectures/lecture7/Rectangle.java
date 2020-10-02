package kyh.lectures.lecture7;

public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width*height;
    }

    public int getCircumference() {
        return 2*width + 2*height;
    }
}
