package org.app.shapes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "shapes")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle")
})
public abstract class Shape {
    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Setter
    @JoinColumn(name="color_id")
    public Color color;

    public Shape(Color color)  {
        this.color = color;
    };

    public Shape() {
        this.color = new Color();
    }

    public String getColorDescription() {
        return ("Red: " + color.red
                + ", Green: " + color.green
                + ", Blue: " + color.blue
                + ", Alpha: " + color.alpha
        );
    }

    public String generateShape() {
        return "Rendering is not implemented yet";
    }

    public void print() {
        String className = this.getClass().getName();
        System.out.println(className);
    }

    public abstract double getArea();
    public abstract double getPerimeter();

}
