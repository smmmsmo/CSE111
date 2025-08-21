public class Player {
    public static int total = 0;
    public static String[] playersList = new String[10]; //static array implementation
    public static int index = 0;

    public String name;
    public String country;
    public int jerseyNumber;

    public Player(String newName, String newCountry, int newJerseyNumber) {
        this.name = newName;
        this.country = newCountry;
        this.jerseyNumber = newJerseyNumber;
        total++;
        
        playersList[index] = name;
        index++;
    }

    public String player_detail() {
        return ("Player Name: " + name + "\n" +
                "Jersey Number: " + jerseyNumber + "\n" +
                "Country: " + country);
    }

    public static void info() {
        System.out.println("Total number of players: " + total);
        
        System.out.print("Players enlisted so far: ");
        for (String x : playersList){
            if(x != null) {
                System.out.print(x + ", ");
            }
        }
        System.out.println();
    }
}
