package org.example;

public abstract class Shape {
    void print() {
        String className = this.getClass().getName();
        System.out.println(className);
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
