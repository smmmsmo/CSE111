public class Shape {
    public String name;
    public String color;

    public void displayInfo() {
        System.out.printf("Name: %s\nColor: %s\n", name, color);
    }
}

class Circle extends Shape {
    public double radius;

    public void area() {
        double area = Math.PI * radius * radius;
        System.out.printf("Area of the circle: %.2f\n", area);
    }
}
