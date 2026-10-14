
import java.util.Arrays;

public class Playlist {

    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount] = title;
            songCount++;
        }
    }

    public String[] getSongs() {

        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("getSongs() -> " + Arrays.toString(copy) + " (expected [Song A, Song B])");

        copy[0] = "Hacked";
        System.out.println("After modifying the returned copy: " + Arrays.toString(p.getSongs()) +
                " (still expected [Song A, Song B])");

        System.out.println("Song count: " + p.getSongCount() + " (expected 2)");
    }
}
