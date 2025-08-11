public class Song {
    //Each song will have the title of the song, artist title, length of the song in minutes and the next song.
    
    String title;
    String artist;
    int length; // in minutes
    Song next;  // link to next Song in playlist

    // Constructor
    public Song(String title, String artist, int length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.next = null; // initially no next song
    }

    // Method to print song info
    public void songInfo() {
        System.out.println("Title: " + title + ",  Artist: " + artist);
        System.out.println("Length: " + length + " minutes");
    }
}