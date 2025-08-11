public class Song {
    //Each song will have the name of the song, artist name, length of the song in minutes and the next song.
    
    public String name;
    public String artist;
    public int length;

    Song(String name, String artist, int length) {
        this.name = name;
        this.artist = artist;
        this.length = length;
    }
    
    public void songInfo() {
        System.out.println("Song Name: " + name +", "+ "Artist: " + artist +", " + "Length: " + length + " minutes");
    }
}
