public class Student{
  public String name;
  public String id;
  public double cgpa;
  public String dept;
  //default constructor
  public Student(){
//    System.out.println("Default Constructor");
  }
  public Student(String nm, String id, double cg, String dp){
    int c = 0;
    this.name = nm;
    this.id = id;
    this.cgpa = cg;
    this.dept = dp;
    System.out.println("4 Param Constructor");
  }
 //access_modifier returnType methodName(){
  public void changeDept(String dp, String id){
//    int x = 20;
    if(dept.equals(dp)){
      System.out.println("Invalid request");
    }else{
      System.out.println(dept + " was changed to " + dp);
      dept = dp;
      this.id = id;
    }
  }
  public void loc_checker(){
    System.out.println("location: " + this);
  }
  public void printDetails(){
    System.out.println("Printing details:");
    System.out.println("Name: " + name);
    System.out.println("ID: " + id);
    System.out.println("CGPA: " + cgpa);
    System.out.println("Department: " + dept);
  }   
  public double calculateGPA(double gp1, double gp2, double gp3, double gp4){
    double avg = (gp1+gp2+gp3+gp4)/4;
//    System.out.println(avg);
    return avg;
  }
  //method overloading
  //difference in parameter count
  //parameter count same, datatype different
  //parameter count and datatype same, datatype sequence different
  public void updateDetails(String nm, double cg){
    this.name = nm;
    this.cgpa = cg;
  }
//  public void updateDetails(String id, double cg){
//    this.id = id;
//    this.cgpa = cg;
//  }
  public void updateDetails(String id){
    this.id = id;
  }
  public void updateDetails(String id, String dp){
    this.id = id;
    this.dept = dp;
  }
  public void updateDetails(double cg, String nm){
    this.name = nm;
    this.cgpa = cg;
  }
}













