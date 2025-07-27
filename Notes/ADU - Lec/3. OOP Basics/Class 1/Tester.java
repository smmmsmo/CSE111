public class Tester{
  public static void main(String [] args){
    int x = 5;
    x = 20;
    Car c1 = new Car(); //object/instance
    System.out.println(c1);
    System.out.println(c1.color);
    c1.color = "Red";
    System.out.println(c1.color);
    c1.color = "Blue";
    c1.model = "GTR";
    c1.year = 2020;
    System.out.println(c1.color+" "+ c1.model + " "+ c1.year);
    System.out.println("===========");
    Car c2 = new Car();
    System.out.println(c2.color+" "+ c2.model + " "+ c2.year);
    System.out.println("===========");
    c2.color = "Blue";
    c2.model = "GTR";
    c2.year = 2020;
    System.out.println(c1.year == c2.year);
    System.out.println(c1.color == c2.color);
    System.out.println(c1.model == c2.model);
    System.out.println(c1 == c2);
    System.out.println("===========");
    c1 = c2;
    c2.color = "Black";
    c2.model = "Premio";
    c2.year = 2010;
    System.out.println(c2.color+" "+ c2.model + " "+ c2.year);
    System.out.println(c1.color+" "+ c1.model + " "+ c1.year);
    System.out.println("==========");
    System.out.println("Printing Details:");
    System.out.println("Color: " + c1.color);
    System.out.println("Model: " + c1.model);
    System.out.println("Year: " + c1.year);
  }
}