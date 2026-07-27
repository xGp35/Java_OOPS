import javax.sound.midi.*;

public class MusicTest2 {
    public static void main(String[] args) {

        // Get a sequencer and open it.
        Sequencer player = MidiSystem.getSequencer();
        player.open();

        // Make a new sequence
        Sequence seq = new Sequence(timing, 4);

        // Get a new track from the sequence
        Track t = seq.createTrack();

        // Fill the track with Midi events and give the Sequence to the Sequencer
        t.add(myMidiEvent1);
        player.setSequence(seq);

        player.start();
    }
}