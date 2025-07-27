import java.util.*;
public class Student  //design/template/Blueprint
{
  public String name;  
  public String id;    
  public Course [] courses = new Course[4];
  public int count = 0;
  //public void method1(Student othr){}
  public Student(String nm, String id){
    this.name = nm;
    this.id = id;
  }
  public void addCourse(Course crs){
    if(count<courses.length){
      courses[count] = crs;
      count++;
    }
  }  
  public void showDetail(){      //instance method
    System.out.println(name+" "+id);
    for(int i=0;i<count;i++){
      System.out.println(courses[i].code);
      System.out.println(courses[i].title);
    }
  }
  public void updateName(String name){  //instance method
    this.name = name;
  }
}