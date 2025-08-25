public class shapeTester {
    public static void main(String[] args) {
        Shape s = new Shape();
        s.name = "Mobius Strip";
        s.color = "Blue";
        s.displayInfo();
        System.out.println("=======================");
        Circle c = new Circle();
        System.out.println("=======================");
        c.name = "Circle";
        c.color = "Red";
        c.radius = 5;
        c.displayInfo();
        System.out.println("=======================");
        c.area();
    }
}

class Shape {
    public String name;
    public String color;

    public void displayInfo() {
        System.out.printf("Name: %s\nColor: %s\n", name, color);
    }
}

class Circle extends Shape {
    public double radius;

    public double area() {
        return Math.PI * radius * radius;
    }
}
