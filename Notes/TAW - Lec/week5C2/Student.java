public class Student  //design/template/Blueprint
{
  public String name;   //instance variable
  public String id;     //instance variable
  public String uniName="Bracu"; //default instance variable
  
  public void method1(Student x){  //pass bt reference
    System.out.println(x.name);
    System.out.println(name);
    System.out.println("Method 1 called");
  }
  
//AccessModifier ClassName(Parameters)
  
  public Student(String nm, String id){
    this.name = nm;
    this.id = id;
    //System.out.println("2 parameter");
  }
  public Student(String nm){
    this.name = nm;
    //System.out.println("1 parameter");
  }
  public Student(){     //Default constructor
    //System.out.println("0 parameter");
  }
  
  public void addCourse(String c1){
    System.out.println(c1+" is added");
  }  
  public void updateName(String name){  //instance method
    this.name = name;
  }
  public void showDetail(){      //instance method
    System.out.println(name+" "+id);
    System.out.println(uniName);
  }
}