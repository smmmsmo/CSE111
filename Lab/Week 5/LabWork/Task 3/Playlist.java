public class Playlist {
    // Each playlist will have a name and the first song. Playlists can contain
    // multiple songs

    public String name;
    public Song start;

    // Constructor
    public Playlist(String name) {
        this.name = name;
        System.out.println(name + " created.");
        start = null; // empty playlist
    }

    // Method to print playlist info
    public void info() {
        System.out.println(name + " has the following songs:");
        if (start == null) {
            System.out.println("No songs in " + name + ".");
        } else {
            Song current = start;
            int songNumber = 1;
            while (current != null) {
                System.out.println("Song-" + songNumber);
                current.songInfo();
                current = current.next; // move to next song
                songNumber++;
            }
        }
    }
}