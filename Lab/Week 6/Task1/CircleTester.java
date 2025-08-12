package Task1;
public class CircleTester {
  public static void main(String[] args) {
    Circle c1 = new Circle(4);
    System.out.println("1---------------");
    System.out.println("First circle radius: " + c1.getRadius());
    System.out.println("First circle area: " + c1.area());
    System.out.println("2---------------");
    Circle c2 = new Circle(5);
    System.out.println("Second circle radius: " + c2.getRadius());
    System.out.println("Second circle area: " + c2.area());
    System.out.println("3---------------");
  }
}
