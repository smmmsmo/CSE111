public class Tester1{
  public static void main(String args[]){
    Employee e1 = new Employee();
    Employee e2 = new Employee("Alif", 34, "Fulltime");
    System.out.println("1-------------");
    Company c1 = new Company();
    c1.details();
    System.out.println("2-------------");
    Employee e3 = new Employee("Akter", 36,"Part-time");
    Employee e4 = new Employee("Ria", 38, "Fulltime");
    System.out.println("3-------------");
    c1.addEmployee(e2);
    c1.addEmployee(e3);
    System.out.println("4-------------");
    c1.details();
    System.out.println("5-------------");
    c1.addEmployee(e4);
    c1.addEmployee(e1);
    System.out.println("6-------------");
    c1.details();
    System.out.println("7-------------");
    c1.removeEmployee(e4);
    System.out.println("6-------------");
    c1.details();
  }
}
    
   
