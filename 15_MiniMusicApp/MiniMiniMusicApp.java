import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMiniMusicApp {
    public static void main(String[] args) {

        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            // Get a sequencer and open it.
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            // Make a new sequence
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            // Get a new track from the sequence
            Track track = seq.createTrack();

            // Fill the track with Midi events
            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 1, 80, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_OFF, 3, 42, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 5);
            track.add(noteOff);

            ShortMessage msg3 = new ShortMessage();
            msg3.setMessage(NOTE_ON, 5, 70, 100);
            MidiEvent noteOn1 = new MidiEvent(msg3, 6);
            track.add(noteOn1);

            ShortMessage msg4 = new ShortMessage();
            msg4.setMessage(NOTE_OFF, 7, 102, 100);
            MidiEvent noteOff1 = new MidiEvent(msg4, 34);
            track.add(noteOff1);

            // Give the Sequence to the Sequencer
            player.setSequence(seq);

            player.start();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}