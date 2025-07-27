public class TeamTester {
 public static void main(String[] args) {
   Player p1 = new Player("Sakep", 37, 200);
   Player p2 = new Player("Tamem", 35, 180);
   p1.details();
   System.out.println("=======1=======");
   p2.details();
   System.out.println("=======2=======");
   p1.addRival(p2);
   System.out.println("=======3=======");
   p1.showRival();
   System.out.println("=======4=======");
   
   Team b = new Team();
   b.updateName("Bangladesh");
   System.out.println("=======5=======");
   b.addPlayer(p1);
   System.out.println("=======6=======");
   b.addPlayer(p2);
   System.out.println("=======7=======");
   b.printDetails();
   System.out.println("=======8=======");
   Team a = new Team("Australia");
   Player p3 = new Player("Ponting", 50, 300);
   a.addPlayer(p3);
   Player p4 = new Player("Lee", 49, 200);
   a.addPlayer(p4);
   a.printDetails();

 }
}