package org.example;


import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;

@Entity
@Table(name="rectangles")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeName("rectangle")
public class Rectangle extends Shape {

    @Column(name="width", nullable = false)
    public final double width;
    @Column(name="height", nullable = false)
    public final double height;

    public Rectangle(int width, int height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this(0,0, null);
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
