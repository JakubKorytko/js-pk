public class ShapeDescriber {
    public static void describe(Shape shape) {
        String area = String.valueOf(shape.getArea());
        String perimeter = String.valueOf(shape.getPerimeter());

        System.out.println("Pole figury: " + area);
        System.out.println("Perimeter figury: " + perimeter);
    }
}
