package org.example;

public abstract class Shape {
    Color color;

    Shape(Color color)  {
        this.color = color;
    };

    String getColorDescription() {
        return ("Red: " + color.red()
                + ", Green: " + color.green()
                + ", Blue: " + color.blue()
                + ", Alpha: " + color.alpha()
        );
    }

    public String generateShape() {
        return "Rendering is not implemented yet";
    }

    void print() {
        String className = this.getClass().getName();
        System.out.println(className);
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
