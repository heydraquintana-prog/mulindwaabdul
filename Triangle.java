public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC, String color, boolean filled) {
        super(color, filled);
        // Step 1: Validate positive bounds
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new InvalidShapeException("Triangle sides must be positive values.");
        }
        // Step 2: Validate Triangle Inequality Theorem
        if ((sideA + sideB <= sideC) || (sideA + sideC <= sideB) || (sideB + sideC <= sideA)) {
            throw new InvalidShapeException("Triangle inequality violation: The sum of any two sides must be strictly greater than the third side.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        // Heron's Formula for calculation
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Received: " + factor);
        }
        this.sideA *= factor;
        this.sideB *= factor;
        this.sideC *= factor;
    }

    @Override
    public String toString() {
        return "Triangle[SideA=" + sideA + ", SideB=" + sideB + ", SideC=" + sideC + ", " + super.toString() + "]";
    }
}