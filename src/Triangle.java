public class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = (a+b+c)/2.0;
        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
