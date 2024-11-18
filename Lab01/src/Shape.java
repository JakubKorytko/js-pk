public abstract class Shape {
    public static void main(String[] args) {
    }

    void print() {
        String className = this.getClass().getName();
        System.out.println(className);
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
