public class Student  //design/template/Blueprint
{
  public String name;   //instance variable
  public String id;     //instance variable
  public String uniName="Bracu"; //default instance variable

  public void addCourse(String c1){
//    String[]dum = {"111"};
//    tester2.main(dum);
    System.out.println(c1+" is added");
  }
  
  public void addCourse(int c1){
    System.out.println(c1+" is added");
  }
  
  public void addCourse(String c1, String c2){
    System.out.println(c1+" "+c2+" are added");
  }
  
  public void updateName(String name){  //instance method
    this.name = name;
  }
  
  public void showDetail(){      //instance method
    System.out.println(name+" "+id);
    System.out.println(uniName);
  }
}