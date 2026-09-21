/*
 * ASSIGNMENT PROBLEM 2: The Playlist
 *
 * Scenario:
 * A music app lets you build a playlist of songs.
 *
 * Problem Statement:
 * Design a Playlist class that stores songs internally but returns a safe
 * copy of the list, so nobody can sneak in changes from outside.
 *
 * Requirements:
 * - Store song titles in a private array (assume a fixed maximum size).
 * - Provide a method to add a song, and one that returns all the songs
 *   added so far - as a copy, not the original array.
 * - Changing the array returned by that method must not affect the
 *   playlist's real contents.
 * - Provide a read-only count of how many songs are in the playlist.
 *
 * Sample:
 *   Playlist p = new Playlist(10);
 *   p.addSong("Song A"); p.addSong("Song B");
 *   String[] copy = p.getSongs();
 *   copy[0] = "Hacked"; // p.getSongs()[0] is still "Song A"
 */
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
        // Return a brand new array with the same contents, so the caller
        // can never modify the playlist's real internal array.
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

        copy[0] = "Hacked"; // modify the returned copy
        System.out.println("After modifying the returned copy: " + Arrays.toString(p.getSongs()) +
                " (still expected [Song A, Song B])");

        System.out.println("Song count: " + p.getSongCount() + " (expected 2)");
    }
}
