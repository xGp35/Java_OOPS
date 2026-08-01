import java.util.*;
import java.util.stream.*;

public class JukeboxStreams {
    public static void main(String[] args) {
        List<Song> songs = new Songs().getSongs();
        
        List<Song> rockSongs = songs.stream()
                                    .filter((Song s) -> s.getGenre().contains("Rock"))
                                    .collect(Collectors.toList());
        
        List<Song> newBeatles = songs.stream()
                                    .filter((Song s) -> s.getArtist().equals("The Beatles") && 
                                                        s.getTitle().startsWith("H") &&
                                                        s.getYear() > 1995)
                                    .collect(Collectors.toList());
        
        List<String> genres =  songs.stream()
                                    .map(s -> s.getGenre())
                                    .distinct()
                                    .collect(Collectors.toList());

        List<String> genres2 =  songs.stream()
                                    .map(Song::getGenre)
                                    .distinct()
                                    .collect(Collectors.toList());  

        Set<String> genres_set = songs.stream()
                                      .map(s -> s.getGenre())
                                      .collect(Collectors.toSet()); 

        String songTitle = "With a Little Help from My Friends";
        List<String> nonBealteArtists = songs.stream()
                                            .filter(song -> song.getTitle().equals(songTitle))
                                            .map(song -> song.getArtist())
                                            .filter(artist -> !artist.equals("The Beatles"))
                                            .collect(Collectors.toList()); 
        //Method references only work when the lambda is just calling a method, without doing anything extra.
        List<String> nonBealteArtists2 = songs.stream()
                                            .filter(song -> song.getTitle().equals(songTitle))
                                            .map(Song::getArtist)
                                            .filter(artist -> !artist.equals("The Beatles"))
                                            .collect(Collectors.toList());   

        List<Song> sorted_by_year = songs.stream()
                                        .sorted((o1, o2) -> o1.getYear() - o2.getYear())
                                        .collect(Collectors.toList());

        List<Song> sorted_by_year2 = songs.stream()
                                        .sorted(Comparator.comparingInt(Song::getYear))
                                        .collect(Collectors.toList());  

        System.out.println(newBeatles);
        System.out.println(genres);
        System.out.println(genres2);
        System.out.println(genres_set);                                  
        System.out.println(nonBealteArtists);                                  
        System.out.println(sorted_by_year);                                  
        System.out.println(sorted_by_year2);                                  
    }
}