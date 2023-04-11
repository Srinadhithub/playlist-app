import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Playlist {
    String title;
    List<Song> songs;
    int currentTrackNo = 0;
    boolean isNext;

    private ListIterator<Song> itr;
    public String getTitle() {
        return title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Playlist(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
        itr = songs.listIterator();
        isNext = false;
    }

    Optional<Song> getSongByTitle(String title) {
        for(Song song: songs) {
            if(song.getTitle().equals(title)) {
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }

    int getCurrentTrackNo()
    {
        return currentTrackNo;
    }

    public boolean addSongFromAlbum(Album album, String title) {
        Optional<Song> song = album.getSongByTitle(title);
        if(song.isEmpty()) {
            return false;
        }
        if(getSongByTitle(title).isEmpty()) {
            songs.add(song.get());
            itr = songs.listIterator(currentTrackNo+1);
            return true;
        }
        return true;
    }

    public String addSongFromAlbum(Album album, int trackNo) {
        Optional<Song> song = album.getSongByTrackNumber(trackNo);
        if(song.isEmpty()) {
            return "Could not add song";
        }
        if(getSongByTitle(title).isEmpty()) {
            songs.add(song.get());
            itr = songs.listIterator(isNext ? currentTrackNo + 1: currentTrackNo);
            return "added song to playlist";
        }
        return "song already present in playlist";
    }

    public String play() {
        if(isNext && itr.hasPrevious()) {
            isNext = false;
            return "currently playing: " + itr.previous();
        }
        if(!isNext && itr.hasNext()) {
            isNext = true;
            return "currently playing: " + itr.next();
        }
        return "no songs to play";
        //return "currently playing: " + songs.get(currentTrackNo);
    }

    public String playNext() {
        if(!isNext) {
            itr.next();
            isNext = true;
        }
        if(itr.hasNext()) {
            currentTrackNo ++;
            isNext = true;
            return "playing next song: " + itr.next();
        }
        return "playlist has come to an end";
    }

    public String playPrevious() {
        if (isNext) {
            itr.previous();
            isNext = false;
        }
        if (itr.hasPrevious()) {
            currentTrackNo--;
            isNext = false;
            return "playing previous song: " + itr.previous();
        }
        return "You are on the first song";
    }
}
