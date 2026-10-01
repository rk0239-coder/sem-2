package Task_3;

class Geometry {

    // Area of square
    void area(int side) {
        System.out.println("Area of Square: " + (side * side));
    }

    // Area of rectangle
    void area(int length, int breadth) {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    // Area of circle
    void area(double radius) {
        System.out.println("Area of Circle: " + (3.14 * radius * radius));
    }
}

public class GeometryDemo {
    public static void main(String[] args) {

        Geometry g = new Geometry();

        g.area(5);        // Square
        g.area(10, 4);    // Rectangle
        g.area(3.5);      // Circle
    }
}