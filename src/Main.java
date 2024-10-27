public class Main {
    public static void main(String[] args) {
        Triangle triangleObj = new Triangle(3,4,5);
        Rectangle rectangleObj = new Rectangle(4, 4);

        ShapeDescriber.describe(triangleObj);
        ShapeDescriber.describe(rectangleObj);
    }
}
