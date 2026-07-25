import java.util.*;

public class Jukebox5 {
    public static void main(String[] args) {
        new Jukebox5().go();
    }

    public void go() {
        List<SongV4> songList = MockSongs.getSongsV4();
        System.out.println(songList);

        Collections.sort(songList);
        System.out.println(songList);

        SongV4 artistCompare = new SongV4();
        songList.sort(artistCompare);
        System.out.println(songList);
        //Collections.sort(songList, artistCompare);
    }
}
