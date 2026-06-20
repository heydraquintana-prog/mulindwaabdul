public class ShapeDriver {
    
    public static void printAreas(Shape[] shapes) {
        System.out.println("--- Area Report via Dynamic Binding ---");
        for (Shape s : shapes) {
            System.out.printf("Object Type: %-12s | Area: %-8.2f | Details: %s%n", 
                s.getClass().getSimpleName(), s.getArea(), s.toString());
        }
    }

    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) return null;
        Shape largestShape = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > largestShape.getArea()) {
                largestShape = shapes[i];
            }
        }
        return largestShape;
    }

    public static void main(String[] args) {
        // Demonstration of Custom Exception & Try-Catch
        System.out.println("================ EXCEPTION TESTING ================");
        try {
            System.out.println("Attempting to construct an invalid triangle with lengths (1, 2, 10)...");
        } catch (InvalidShapeException e) {
            System.out.println("Caught Expected Exception Successfully!");
            System.out.println("Error message: " + e.getMessage());
        }
        System.out.println("===================================================\n");

        // Create clean active polymorphic shape instances
        Shape[] shapeCollection = new Shape[3];
        shapeCollection[0] = new Circle(5.0, "Blue", true);
        shapeCollection[1] = new Rectangle(4.0, 6.0, "Yellow", false);
        shapeCollection[2] = new Triangle(3.0, 4.0, 5.0, "Green", true);

        System.out.println("========= INITIAL GEOMETRIC STATUS =========");
        printAreas(shapeCollection);
        
        Shape maximumAreaShape = largest(shapeCollection);
        System.out.println("\n-> The largest item is: " + maximumAreaShape);

        System.out.println("\n========= SCALE RESIZE ACTIONS (Scaling by factor of 2) =========");
        for (Shape s : shapeCollection) {
            s.resize(2.0);
        }
        
        printAreas(shapeCollection);
        maximumAreaShape = largest(shapeCollection);
        System.out.println("\n-> The largest item after scaling is: " + maximumAreaShape);
    }
}