public class Playlist {
    String name;
    Song start; // first song in the playlist

    public Playlist(String name) {
        this.name = name;
        this.start = null;
        System.out.println(name + " created.");
    }

    public void info() {
        System.out.println(name + " has the following songs:");
        if (start == null) {
            System.out.println("No songs in " + name + ".");
            return;
        }
        Song temp = start;
        int index = 1;
        while (temp != null) {
            System.out.println("Song-" + index);
            temp.songInfo();
            temp = temp.next;
            index++;
        }
    }

    // Add song at the end
    public void addSong(Song s) {
        if (start == null) {
            start = s;
        } else {
            Song temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = s;
        }
        System.out.println(s.title + " added to " + name + ".");
    }

    // Add song at beginning or end depending on flag
    public void addSong(Song s, boolean atBeginning) {
        if (atBeginning) {
            s.next = start;
            start = s;
        } else {
            addSong(s);
            return; // message already printed by addSong(s)
        }
        System.out.println(s.title + " added to " + name + ".");
    }

    // Play by title
    public void playSong(String songTitle) {
        Song temp = start;
        while (temp != null) {
            if (temp.title.equals(songTitle)) {
                System.out.println("Playing " + temp.title + " by " + temp.artist + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println(songTitle + " not found in " + name + ".");
    }

    // Play by index (0-based)
    public void playSong(int index) {
        Song temp = start;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                System.out.println("Playing " + temp.title + " by " + temp.artist + ".");
                return;
            }
            temp = temp.next;
            count++;
        }
        System.out.println("Song at Index " + index + " not found in " + name + ".");
    }

    // Delete last song
    public void deleteSong() {
        if (start == null) return;
        if (start.next == null) {
            System.out.println(start.title + " deleted from " + name);
            start = null;
            return;
        }
        Song temp = start;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.next.title + " deleted from " + name);
        temp.next = null;
    }

    // Delete first song or last song based on flag
    public void deleteSong(boolean fromBeginning) {
        if (start == null) return;
        if (fromBeginning) {
            System.out.println("First Song Deleted!");
            start = start.next;
        } else {
            deleteSong();
        }
    }

    // Count songs
    public int totalSong() {
        int count = 0;
        Song temp = start;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Merge another playlist at the end
    public void merge(Playlist other) {
        if (other.start == null) {
            System.out.println("Merge Completed!");
            return;
        }
        if (start == null) {
            start = other.start;
        } else {
            Song temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = other.start;
        }
        System.out.println("Merge Completed!");
    }
}
