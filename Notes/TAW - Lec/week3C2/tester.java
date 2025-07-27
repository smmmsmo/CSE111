public class tester   //driver
{
  public static void main(String[]args)
  {
    //ClassName variable = new ClassName()
    Student s1 = new Student(); //Object 1/instance 1
    Student s2 = new Student(); //Object 2/instance 2
    Student s3;
    s1.name = "Bob";
    s1.id = "11";
    s2.name = "Carol";
    s2.id = "33";
    s3 = s2;
    s3.name = "David";
    System.out.println(s2.name+" "+s2.id);
    System.out.println(s2.uniName);
    System.out.println("============");
    System.out.println(s3.name+" "+s3.id);
    System.out.println(s3.uniName);
  }
}