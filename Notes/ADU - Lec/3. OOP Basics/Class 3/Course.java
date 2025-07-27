public class Course{
  public String name;
  public String code;
  public int credit;
  public void createCourse(String nm, String cd, int cr){
    name = nm;
    code = cd;
    credit = cr;
  }
  public void displayCourse(){
    System.out.println("Course Name: " + name);
    System.out.println("Course Code: " + code);
    System.out.println("Course Credit: " + credit);
  }
  public void updateCourse(String nm, String cd, int cr){
    name = nm;
    code = cd;
    credit = cr;
  }
}
