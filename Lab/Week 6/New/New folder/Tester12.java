public class Tester12 {
 public static void main(String[] args) {
  Student s1 = new Student("Akib", 10, 3.29);
  Student s2 = new Student("Reza", 15, 3.45);
  Student s3 = new Student("Kabir", 20,4.0);
  System.out.println("1===========");
  Department cse = new Department("CSE");
  cse.findStudent(-100);
  System.out.println("2===========");
  cse.addStudent(s1, s2, s3);
  System.out.println("3===========");
  cse.details();
  System.out.println("4===========");
  cse.findStudent(15);
  System.out.println("5===========");
  Student s4 = new Student("Nakib", 15,3.22);
  cse.addStudent(s4);
  System.out.println("6===========");
  s4.setId(25);
  cse.addStudent(s4);  
  System.out.println("7===========");
  cse.details();
  System.out.println("8===========");
  Student s5 = new Student("Sakib", 30,2.29);
  cse.addStudent(s5);
  System.out.println("9===========");
  cse.details();
 }
}
