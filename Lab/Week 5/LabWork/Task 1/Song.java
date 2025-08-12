public class Song {
    //Each song will have the name of the song, artist name, length of the song in minutes and the next song.
    String title;
    String artist;
    int length;

    Song(String songName, String artist, int length) {
        this.title = songName;
        this.artist = artist;
        this.length = length;
    }
    
    public void songInfo() {
        System.out.println("Title: " + title +", "+ "Artist: " + artist +", " + "Length: " + length + " minutes");
    }
}
