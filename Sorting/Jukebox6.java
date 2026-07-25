import java.util.*;

public class Jukebox6 {
    public static void main(String[] args) {
        new Jukebox5().go();
    }

songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));