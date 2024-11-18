package org.example;

public class Rectangle extends Shape {
    public final double width;
    public final double height;

    public Rectangle(int width, int height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public String generateShape() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            result.append("* ".repeat((int)width));
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return width*2 + height*2;
    }
}
