import java.util.*;

public class Jukebox5 {
    public static void main(String[] args) {
        new Jukebox5().go();
    }

    public void go() {
        List<SongV31> songList = MockSongs.getSongsV4();
        System.out.println(songList);

        Collections.sort(songList);
        System.out.println(songList);

        SongV31 artistCompare = new SongV31();
        songList.sort(artistCompare);
        System.out.println(songList);
        //Collections.sort(songList, artistCompare);
    }
}
