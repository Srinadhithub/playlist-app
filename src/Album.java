import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {
    String title;
    String author;
    List<Song> songs;

    public Album(String title, String author, List<Song> songs) {
        this.title = title;
        this.author = author;
        this.songs = songs;
    }

    public Album(String title, String author) {
        this.title = title;
        this.author = author;
        this.songs = new ArrayList<>();
    }

    Optional<Song> getSongByTitle(String title) {
        for(Song song: songs) {
            if(song.getTitle().equals(title)) {
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }

    Optional<Song> getSongByTrackNumber(int trackNo) {
        if(trackNo <= songs.size()) {
            return Optional.of(songs.get(trackNo-1));
        }
        return Optional.empty();
    }

    void addSong(String title, double duration) {
        if(getSongByTitle(title).isEmpty()) {
            songs.add(new Song(title, duration));
        }
    }

    void addSong(Song song) {
        if(getSongByTitle(song.getTitle()).isEmpty()) {
            songs.add(song);
        }
    }

}
