public class CourseTester{
  public static void main(String [] args){
    Course c1 = new Course("PL II", "CS11");
    System.out.println("--------1--------");
    System.out.println(c1.printDetails());
    System.out.println("--------2--------");
    c1.addContent("Overloading");
    System.out.println(c1.printDetails());
    System.out.println("--------3--------");
    c1.addContent("Encapsulation");
    c1.addContent("Static", "Polymorphism");
    System.out.println(c1.printDetails());
    System.out.println("--------4--------");
    c1.addContent("Inheritance");
    System.out.println("--------5--------");
    Course c2 = new Course("DS", "CS22");
    c2.addContent("Stack");
    c2.addContent("Recursion","Tree");
    c2.addContent("Heap","Hashing");
    System.out.println("--------6--------");
    System.out.println(c2.printDetails());
    System.out.println("--------7--------");
    Course c3 = new Course("OS");
    c3.addContent("Scheduling");
    System.out.println("--------8--------");
    c3.addContent(new String[]{"Segmentation", "Process", "Interrupt","concurrency"});
    System.out.println("--------9--------");
    System.out.println(c3.printDetails());
  }
}




