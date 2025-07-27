public class tester   //driver
{
  public static void main(String[]args)
  {    
    Student s1 = new Student(); //Object 1/instance 1
    Student s2 = new Student(); //Object 2/instance 2
    s1.name = "Bob";
    s1.id = "11";
    s2.name = "Carol";
    s2.id = "33";
    s1.addCourse("CSE111");  //argument
//    s1.addCourse("MAT120", "ECO101");
//    s1.addCourse(230);
    
    
//    s1.showDetail();
//    System.out.println("============");
//    s2.showDetail();
  }
}