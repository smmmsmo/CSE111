public class Course {
  public String name;
  public String code;
  public String [] contents = new String[4];
  public int count = 0;

  public Course(String name, String code){
    this.name = name;
    this.code = code;
  }
  public Course(String name){
    this.name = name;
    this.code = "Undefined";
  }
  public void addContent(String cont){
    if(count < contents.length){
      contents[count] = cont;
      count++;
      System.out.println(cont + " was added");
    }
    else {
      System.out.println("Cannot add more content");
    }
  }
  public void addContent(String cont, String cont2){
    if (count < contents.length - 1){
      contents[count] = cont;
      count++;
      System.out.println(cont + " was added");
      contents[count] = cont2;
      count++;
      System.out.println(cont2 + " was added");
    }
    else if(count == contents.length - 1){
      contents[count] = cont;
      count++;
      System.out.println(cont + " was added");
      System.out.println("Cannot add more content");
    }
    else {
      System.out.println("Cannot add more content");
    }

    //ALTERNATIVE APPROACH: shortcut
//    if (count < contents.length - 1){
//      addContent(cont);
//      addContent(cont2);
//    }
//    else if(count == contents.length - 1){
//      addContent(cont);
//      System.out.println("Cannot add more content");
//    }
//    else {
//      System.out.println("Cannot add more content");
//    }
  }
  public void addContent(String [] conts){
    for (int i = 0; i < conts.length; i++) {
      if(count < contents.length){
        contents[count] = conts[i];
        count++;
        System.out.println(conts[i] + " was added");
      }
      else {
        System.out.println("Cannot add more content");
        break;
      }
    }

    //ALTERNATIVE APPROACH
//    for (int i = 0; i < conts.length; i++) {
//      if(count < contents.length){
//        addContent(conts[i]);
//      }
//      else {
//        System.out.println("Cannot add more content");
//        break;
//      }
//    }
  }
  public String printDetails(){
    String st = "Course Details:\n"; 
    st += "Course Name: " + name +"\nCourse Code: " + code+"\n";
    st += "Course Syllabus:";
    if (count > 0){
      st += "\n";
      for (int i = 0; i < count; i++) {
        if(i == count -1){
          st += contents[i];
        }
        else {
          st += contents[i] + ", ";
        }
      }
    }
    else{
      st += "\nNo content yet";
    }
    return st;
  }
}