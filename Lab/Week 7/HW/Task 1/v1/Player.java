public class Player {
    public static int total = 0;
    public static String playerNameList = ""; // static string implementation

    public String name;
    public String country;
    public int jerseyNumber;

    public Player(String newName, String newCountry, int newJerseyNumber) {
        this.name = newName;
        this.country = newCountry;
        this.jerseyNumber = newJerseyNumber;
        total++;

        playerNameList = playerNameList + ", " + name;

    }

    public String player_detail() {
        return ("Player Name: " + name + "\n" +
                "Jersey Number: " + jerseyNumber + "\n" +
                "Country: " + country);
    }

    public static void info() {
        System.out.println("Total number of players: " + total);
        System.out.println("Players enlisted so far: " + playerNameList);
    }
}
