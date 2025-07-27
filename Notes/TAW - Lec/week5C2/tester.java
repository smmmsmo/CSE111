public class tester   //driver
{
  public static void main(String[]args)
  {    
    Student s1 = new Student("Bob", "11"); //Object 1/instance 1
    Student s2 = new Student("Carol"); //Object 2/instance 2   
    String val = "cs";
    s1.method1(s2);
    //s1.showDetail(); 
    System.out.println("============");
    //s2.showDetail(); 
  }
}