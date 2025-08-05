public class Team {
    public String teamName;
    public Player[] players;
    public int playerCount;
    
    public Team() {
        this.players = new Player[10];
        this.playerCount = 0;
    }
    
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new Player[10];
        this.playerCount = 0;
    }
    
    public void updateName(String teamName) {
        this.teamName = teamName;
    }
    
    public void addPlayer(Player name) {
        if (playerCount < players.length) {
            players[playerCount] = name;
            playerCount++;
        }
    }
    
    public void printDetail() {
        System.out.println("Team: " + teamName);
        System.out.println("List of players: ");
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Name: " + players[i].name);
            System.out.println("Age: " + players[i].age + ", Total Matches: " + players[i].totalMatches);
        }
    }
}
