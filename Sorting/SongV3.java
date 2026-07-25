class SongV3 implements Comparable<SongV3> {
    private String title;
    private String artist;
    private int bpm;

    public int compareTo(SongV3 s) { // this is the method in Comparable interface that I need to implement
        return title.compareTo(s.getTitle());
    }

    SongV3(String title, String artist, int bpm) {
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