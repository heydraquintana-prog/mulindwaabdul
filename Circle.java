public class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        if (radius <= 0) {
            throw new InvalidShapeException("Invalid Circle radius: " + radius + ". Must be positive.");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Received: " + factor);
        }
        this.radius *= factor;
    }

    @Override
    public String toString() {
        return "Circle[Radius=" + radius + ", " + super.toString() + "]";
    }
}