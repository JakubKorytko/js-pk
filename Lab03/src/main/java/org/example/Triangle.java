package org.example;

public class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c, Color color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String generateShape() {
        double max = Math.max(a, Math.max(b, c));
        int height = (int) max;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < height; i++) {
            result.append(" ".repeat((height - i - 1)));
            result.append("*".repeat(Math.max(0, (2 * i + 1))));
            result.append("\n");
        }

        return result.toString();
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
