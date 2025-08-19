public class Player {
    public static int total = 0;
    public static String playersList = "";
    
    public String name;
    public String country;
    public int jrsynum;
    
    public Player(String newName, String newCountry, int newJrcyNum) {
        this.name = newName;
        this.country = newCountry;
        this.jrsynum = newJrcyNum;
        
        total++;
        
        if (playersList.equals("")) {
            playersList = name;
        } else {
            playersList = playersList + ", " + name;
        }
    }
    
    public String player_detail() {
        return "Player Name: " + name + "\n" +
                "Jersey Number: " + jrsynum + "\n" +
                "Country: " + country;
    }
    
    public static void info() {
        System.out.println("Total number of players: " + total);
        System.out.println("Players enlisted so far: " + playersList);
    }
}
