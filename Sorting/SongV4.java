class SongV4 implements Comparable<SongV4>, Comparator<SongV4> {
    private String title;
    private String artist;
    private int bpm;

    @override
    public int compareTo(SongV4 s) { // this is the method in Comparable interface that I need to implement
        return title.compareTo(s.getTitle());
    }

    @override
    public static int compare(SongV3 one, SongV3 two) {
        return one.getArtist().compareTo(two.getArtist());
    }
    // Although it's usually better design to put the Comparator in a separate class 
    // (or a static nested class), Java allows a class to implement both interfaces.

    SongV4(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
    }
    /*
    We override toString(), because when you do System.out.println(aSongObject),
    we want to see the title. When you do System.out.println(aListOfSongs), it calls the
    toString() method of EACH element in the list. 
    */
}