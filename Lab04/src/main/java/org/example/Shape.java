package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "shapes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="color_id")
    Color color;

    Shape(Color color)  {
        this.color = color;
    };

    public Shape() {
        this.color = new Color();
    }

    String getColorDescription() {
        return ("Red: " + color.red
                + ", Green: " + color.green
                + ", Blue: " + color.blue
                + ", Alpha: " + color.alpha
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
