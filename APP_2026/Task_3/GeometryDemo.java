package Task_3;

class Geometry {

    void area(int side) {
        System.out.println("Area of Square: " + (side * side));
    }

    void area(int length, int breadth) {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    void area(double radius) {
        System.out.println("Area of Circle: " + (3.14 * radius * radius));
    }
}

public class GeometryDemo {
    public static void main(String[] args) {

        Geometry g = new Geometry();

        g.area(5);
        g.area(10, 4);
        g.area(3.5);
    }
}