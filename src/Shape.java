public class Shape {
    public static void main(String[] args) {
        Shape newShape = new Shape();
        newShape.print();
    }

    void print() {
        String className = this.getClass().getName();
        System.out.println(className);
    }
}
