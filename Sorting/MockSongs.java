import java.util.List;
import java.util.ArrayList;

class MockSongs {
    public static List<String> getSongStrings() {
        
        List<String> songs = new ArrayList<>();
        songs.add("lock_the_fuck_in");
        songs.add("what_youd_do_if_you_arent_afraid");
        songs.add("nothing_is_worthwile_if_you_dont_take_risks");
        songs.add("raw_action_solves_everything");
        songs.add("comfort_is_the_enemy");
        songs.add("think_Outside_what_you_see");

        return songs;
    }
    
    public static List<SongV2> getSongsV2() {
        List<SongV2> songs = new ArrayList<>();

        songs.add(new SongV2("lock_the_fuck_in", "Greg Pitt", 147));
        songs.add(new SongV2("what_youd_do_if_you_arent_afraid", "David Goggins", 158));
        songs.add(new SongV2("nothing_is_worthwile_if_you_dont_take_risks", "Denzel", 140));
        songs.add(new SongV2("raw_action_solves_everything", "Andrew Tate", 183));
        songs.add(new SongV2("comfort_is_the_enemy", "Mushashi", 158));
        songs.add(new SongV2("work_Works", "Top G", 143));

        return songs;
    }
    
    public static List<SongV3> getSongsV3() {
        List<SongV3> songs = new ArrayList<>();

        songs.add(new SongV3("lock_the_fuck_in", "Greg Pitt", 147));
        songs.add(new SongV3("what_youd_do_if_you_arent_afraid", "David Goggins", 158));
        songs.add(new SongV3("nothing_is_worthwile_if_you_dont_take_risks", "Denzel", 140));
        songs.add(new SongV3("raw_action_solves_everything", "Andrew Tate", 183));
        songs.add(new SongV3("comfort_is_the_enemy", "Mushashi", 158));
        songs.add(new SongV3("work_Works", "Top G", 143));

        return songs;
    }
}
