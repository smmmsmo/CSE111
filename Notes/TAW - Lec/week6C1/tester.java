public class tester   //driver
{
  public static void main(String[]args)
  {    
    Course c1 = new Course("CSE111", "Prog Lang-2");
    Course c2 = new Course("MAT120", "Intgr");
    Student s1 = new Student("Bob", "11"); //Object 1/instance 1
    s1.method1(s2);
    s1.addCourse(c1); //s1.addCourse(c2);
    s1.showDetail(); 
    c1.title = "OOP";
    s1.showDetail();
  }
}