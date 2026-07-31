import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

// This is non working version of MiniMusicPlayer2 to show where the code for 
// ControllerEventListener interface (L#6) and its SAM method would have gone (L#37-42)
public class MiniMusicPlayer2 implements ControllerEventListener {
    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }
    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(event -> System.out.println("la"), eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 25; i < 100; i += 5) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
                track.add(mkaeEvent(CONTROL_CHANGE, 1, 127, 0, i));
                track.add(makeEvent(NOTE_OFF, 1, i, 100, i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);

            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void controlChange(ShortMessage event) {
        // I received the event.
        // I know I need to redraw myself.
        repaint()
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