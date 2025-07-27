public class StudentTest{
  public static void main(String [] args){
    Student s1 = new Student();
    s1.name = "Bob";
    s1.id = "15";
    s1.cgpa = 3.7;
    s1.dept = "CSE";
//    System.out.println("Printing details:");
//    System.out.println("Name: " + s1.name);
//    System.out.println("ID: " + s1.id);
//    System.out.println("CGPA: " + s1.cgpa);
//    System.out.println("Department: " + s1.dept);
    s1.printDetails();
    s1.cgpa = 3.55;
    s1.printDetails();
//    System.out.println("Printing details:");
//    System.out.println("Name: " + s1.name);
//    System.out.println("ID: " + s1.id);
//    System.out.println("CGPA: " + s1.cgpa);
//    System.out.println("Department: " + s1.dept);
    System.out.println("============");
    Student s2 = new Student();
    s2.name = "Alice";
    s2.id = "17";
    s2.cgpa = 2.6;
    s2.dept = "CS";
    s2.printDetails();
    System.out.println("============");
    s1.changeDept("ENH", "51");
    s1.printDetails();
    System.out.println("============");
    s2.changeDept("CS", "31");
    s2.printDetails();
    System.out.println("============");
    System.out.println("s1: " + s1);
    s1.loc_checker();
    System.out.println("------------");
    System.out.println("s2: " + s2);
    s2.loc_checker();
    System.out.println("============");
    //return
//    int x = 21;
    double gpa1 = s1.calculateGPA(3.3,3.7,4.0,2.7);
    double gpa2 = s2.calculateGPA(3.0,3.7,4.0,3.7);
    //System.out.println( );
    System.out.println(s1.calculateGPA(3.3,3.7,4.0,2.7));
    s1.updateDetails("Trudy", 3.94);
    s1.updateDetails("777");
    s1.updateDetails("123", "EEE");
    System.out.println("============");
    Student s3 = new Student();
    Student s4 = new Student("John", "456", 3.33, "EEE");
  }
}
















