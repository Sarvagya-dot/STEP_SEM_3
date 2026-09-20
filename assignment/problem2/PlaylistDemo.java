import java.util.Arrays;

public class PlaylistDemo {

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);

        playlist.addSong("Song A");
        playlist.addSong("Song B");

        String[] copy = playlist.getSongs();
        System.out.println("getSongs() -> " + Arrays.toString(copy));

        copy[0] = "Hacked";
        System.out.println("After modifying the returned copy, getSongs() -> " + Arrays.toString(playlist.getSongs()));
        System.out.println("getSongCount() -> " + playlist.getSongCount());
    }
}

class Playlist {
    private String[] songs;
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
        String[] songsCopy = new String[songCount];
        for (int index = 0; index < songCount; index++) {
            songsCopy[index] = songs[index];
        }
        return songsCopy;
    }

    public int getSongCount() {
        return songCount;
    }
}
