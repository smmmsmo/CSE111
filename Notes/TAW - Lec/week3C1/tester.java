public class tester
{
  public static void main(String[]args)
  {
    //ClassName variable = new ClassName()
    Student s1 = new Student(); //Object 1/instance 1
    Student s2 = new Student(); //Object 2/instance 2
    s1.name = "Bob";
    System.out.println(s1.name);
    System.out.println(s1.id);
    System.out.println("============");
    System.out.println(s2.name);
    System.out.println(s2.id);
  }
}