import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayer1 {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 25; i < 100; i += 5) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
                track.add(makeEvent(NOTE_OFF, 1, i, 100, i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);

            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        // tick is when the message should happen
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(command, channel, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}