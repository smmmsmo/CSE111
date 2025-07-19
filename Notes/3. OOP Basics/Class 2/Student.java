public class Student{
  public String name;
  public String id;
  public double cgpa;
  public String dept;
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
}