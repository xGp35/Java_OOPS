import java.util.*;

public class Jukebox10 {
    public static void main(String[] args) {
        new Jukebox10().go();
    }

    public void go() {
        List<SongV4> songList = MockMoreSongs.getSongsV4();
        System.out.println(songList);

        // Sort by title ascending
        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        Set<SongV4> songSet = new TreeSet<>(songList);
        System.out.println(songSet);
        // This songSet is sorted

        // Sorted by BPM
        Set<SongV4> newSongSet = new TreeSet<>((o1,o2)-> o1.getBpm() - o2.getBpm());
        newSongSet.addAll(songList);
        System.out.println(newSongSet);
        // This songSet is sorted

    }
}