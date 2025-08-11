public class SpotifyTester {
    public static void main(String[] args) {
        Song s1 = new Song("Song-A", "Artist-A", 3);
        System.out.println("1===========");
        s1.songInfo();
        System.out.println("2===========");
        // More lines will be added in this Tester class
        // Continuation from Task 1
        Playlist p1 = new Playlist("First Playlist");
        System.out.println("3===========");
        // Continuation from Task 2
        p1.info();
        System.out.println("4===========");
        p1.start = s1;
        p1.info();
        System.out.println("5===========");
        Song s2 = new Song("Song-B", "Artist-B", 4);
        Song s3 = new Song("Song-C", "Artist-C", 2);
        p1.start.next = s2;
        p1.start.next.next = s3;
        p1.info();
        System.out.println("6===========");
        // Continuation from Task 3
        Song s4 = new Song("Song-D", "Artist-D", 3);
        Song s5 = new Song("Song-E", "Artist-E", 4);
        p1.addSong(s4);
        p1.addSong(s5);
        System.out.println("7===========");
        p1.info();
        System.out.println("8===========");

    }
}
