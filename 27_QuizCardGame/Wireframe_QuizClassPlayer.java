public class QuizCardPlayer {
    public void go() {
        //build and disl
    }

    public void nextCard() {
        // if this is a question then show the answer, otherwise show next question
        // Set a flag for whether we're viewing a question or answer
    }

    private void open() {
        // bring up a file dialog box
        // let the user navigate to and choose a card set to open
    }

    private void loadFile(File file) {
        // must build an Arraylist of cards, by reading them from a text file called from
        // the OpenMenuListener event handler, reads the file one line at a time and tells the 
        // makeCard() method to make a new card out of the line (one line in the file
        // hold both the question and answer, separated by a "/")
    }

    private void makeCard(String lineToPass) {
        // called by the loadFile method, takes a line from the text file and parses into
        // two-pieces-question and answer-and creates a new QuizCard and adds it to the
        // ArrayList called CardList
    }
}