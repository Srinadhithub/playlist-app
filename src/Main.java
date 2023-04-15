// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Gloria","Sam Smith");
        album1.addSong("Unholy", 2.23);
        album1.addSong("Perfect", 3.2);
        album1.addSong("Gloria", 2.1);

        Album album2 = new Album("Honestly, Nevermind", "Drake");
        album2.addSong("Her Loss", 1.4);
        album2.addSong("Views", 1.8);
        album2.addSong("Take Care", 2.2);

        Playlist myPlaylist = new Playlist("myPlaylist");
        myPlaylist.addSongFromAlbum(album1, 1); //unholy
        myPlaylist.addSongFromAlbum(album1,3); //gloria
        myPlaylist.addSongFromAlbum(album2, 1); //her loss
        myPlaylist.addSongFromAlbum(album2, 3); //take care

        System.out.println(myPlaylist.play()); //unholy
        System.out.println(myPlaylist.playPrevious()); // nothing

        System.out.println(myPlaylist.playNext()); //gloria

        System.out.println(myPlaylist.playNext()); //her loss

        System.out.println(myPlaylist.playPrevious()); //gloria

        System.out.println(myPlaylist.addSongFromAlbum(album1,2)); //
        System.out.println(myPlaylist.play()); //gloria

        System.out.println(myPlaylist.playNext()); // her loss

    }
}
