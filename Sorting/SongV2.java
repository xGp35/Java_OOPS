class SongV2 {
    private String title;
    private String artist;
    private int bpm;

    SongV2(String title, String artist, int bpm) {
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