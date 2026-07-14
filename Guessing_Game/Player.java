/**
 * Player
 */
public class Player {

    public int number;

    public void guess() {
        // generate a random number between 0 and 9 (inclusive)
        this.number = (int) (Math.random() * 10);
    }

}
