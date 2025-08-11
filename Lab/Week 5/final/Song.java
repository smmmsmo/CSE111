public class Song {
    String title;
    String artist;
    int length; // in minutes
    Song next; // pointer to the next song

    public Song(String title, String artist, int length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.next = null;
    }

    public void songInfo() {
        System.out.println("Title: " + title + ",  Artist: " + artist);
        System.out.println("Length: " + length + " minutes");
    }
}
