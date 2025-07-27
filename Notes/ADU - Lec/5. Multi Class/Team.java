public class Team{
  public String name;
  public Player [] players = new Player[4];
  int count=0;
  public Team(){
    name = "Default";
  }
  public Team(String nm){
    this.name = nm;
  }
  public void updateName(String nm){
    name = nm;
  }
  public void addPlayer(Player p){
    if(count <  players.length){
      players[count] = p;
      count++;
      System.out.println("Player "+ p.name +" added");
    }
    else{
      System.out.println("Cannot add");
    }
  }
  public void printDetails(){
    System.out.println("Team: "+name);
    System.out.println("List of players:");
    for(int i = 0; i < count; i++){
      players[i].details();
//      System.out.println("Name: "+players[i].name);
//      System.out.println("Age: " + players[i].age + ", Total matches: " + players[i].matches);
    }
  }
}
















