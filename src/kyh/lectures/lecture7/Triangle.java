package kyh.lectures.lecture7;

public class Triangle implements Shape {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getArea() {
        return (b*a)/2;
    }

    public int getCircumference() {
        return a+b+c;
    }
}
