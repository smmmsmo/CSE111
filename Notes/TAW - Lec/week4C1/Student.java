public class Student  //design/template/Blueprint
{
  public String name;   //instance variable
  public String id;     //instance variable
  public String uniName="Bracu"; //default instance variable

//AccessModifier void/return_type methodName(Parameters)
  
  public void updateName(String name){  //instance method
    //System.out.println("design a"+this);
    this.name = name;
  }
  
  public void showDetail(){      //instance method
    System.out.println(name+" "+id);
    System.out.println(uniName);
  }
}