public class Playlist {
    // Each playlist will have a name and the first song. Playlists can contain
    // multiple songs

    String playlistName;
    Song start;

    public Playlist(String playlistTitle) {
        this.playlistName = playlistTitle;
        this.start = null;
        System.out.println(playlistTitle + " created.");
    }

    public void info() {
        System.out.println(playlistName + " has the following songs: ");
        if (start == null) {
            System.out.println("No songs in " + playlistName + ".");
        } else {
            int songNumber = 1;
            Song temp = start;

            while (temp != null) {
                System.out.println("Song-" + songNumber);
                temp.songInfo();
                temp = temp.next;
                songNumber++;
            }
        }
    }

    public void addSong(Song NewSongRef) {
        if (start == null) {
            start = NewSongRef;
        } else {
            Song temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = NewSongRef;
        System.out.println(NewSongRef.title + " added to " + playlistName + ".");

        }

    }
}
