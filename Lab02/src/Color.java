public record Color(int red, int green, int blue, int alpha) {
    public Color  {
        boolean lessThan0 = red < 0 ||  green < 0 ||  blue < 0 || alpha < 0;
        boolean greaterThan255 = red > 255 || green > 255 || blue > 255 || alpha > 255;
        if (greaterThan255 || lessThan0) {
            throw new IllegalArgumentException("Invalid color");
        }
    }

    public Color() {
        this(0, 0, 0, 0);
    }

    public Color(int red) {
        this(red, 0, 0, 0);
    }

    public Color(int red, int green) {
        this(red, green, 0, 0);
    }

    public Color(int red, int green,  int blue) {
        this(red, green, blue, 0);
    }
}
