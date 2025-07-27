public class Player{
  public String name;
  public int age;
  public int matches;
//  public String r_name;
//  public int r_age;
//  public int r_matches;
  public Player rival;
  public Player(String nm, int age, int mat){
    name = nm;
    this.age = age;
    matches = mat;
  }
  public void details(){
    System.out.println("Name: "+name);
    System.out.println("Age: " + age + ", Total matches: " + matches);
  }
  public void addRival(Player rival){
//    r_name = rival.name;
//    r_age = rival.age;
//    r_matches = rival.matches;
    this.rival = rival;
  }
  public void showRival(){
    System.out.println("Rival of "+name + " is " + rival.name);
    System.out.println("Rival stats:");
    rival.details();
//    System.out.println("Name: "+rival.name);
//    System.out.println("Age: " + rival.age + ", Total matches: " + rival.matches);
  }
}









