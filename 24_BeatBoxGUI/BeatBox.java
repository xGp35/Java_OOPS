import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.sound.midi.ShortMessage.*;

public class BeatBox {
    private ArrayList<JCheckBox> checkboxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    String [] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", 
    "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", 
    "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};

    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    public void buildGUI() {
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // An "empty border" gives us a margin betweene edges of a panel and where
        // the components are p;aced. Purely Aesthetic

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> buildTrackAndStart());
        buttonBox.add(start);
        //Lambda expressions are perfect for these event handlers, since when these buttons
        //are pressed, all we want to do is call a specific method

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> sequencer.stop());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(e -> changeTempo(1.03f));
        buttonBox.add(upTempo);
        //The default tempo is 1.0, so we’re adjusting +/- 3% per click.
        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(downTempo);


        // Left side element, i.e, list of all instrument names
        // Box nameBox = new Box(BoxLayout.Y_AXIS);
        // I am changing nameBoc to be a Panel called namePanel instead of a box to make sure it streches
        // according to the checkboxes when I resize the window
        JPanel namePanel = new JPanel(new GridLayout(16, 1));
        for (String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            namePanel.add(instrumentLabel);
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, namePanel);
        // place the left and right elements of out app, on the background panel

        frame.add(background);
        // add out "background" panel to the frame

        GridLayout grid = new GridLayout(16, 20);
        grid.setVgap(1);
        grid.setHgap(2);
        // Anohter layout manager, this one lets you put the components in a grid with rows and columns

        JPanel mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);
        // Creating a New Panel to be put above background panel. This will house the checkboxes

        checkboxList = new ArrayList<>();
        for (int i = 0; i < 320; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildTrackAndStart() {
        int[] trackList;
        // We're making a 20 element array to hold the values for one instrument, 
        // across all 20 beats. If the instrument is supposed to play on that beat, the value 
        // at that element will be the key. If that element is not supposed to play, put a zero

        sequence.deleteTrack(track); // Get rid of old track, but why??
        track = sequence.createTrack(); // create a fresh one

        for (int i = 0; i < 16; i++) { // There are 16 instruments
            trackList = new int[20]; // do this for each of 16 rows(i.e, Bass, Congo)

            int key = instruments[i]; 
            // set the "key" that represents the instrument. Check instance variable instruments.

            for (int j = 0; j < 20; j++) { // do this for each of the beats for this row
                JCheckBox jc = checkboxList.get(j + 20 *i);
                if (jc.isSelected()) {  // Is checkBox selected, if yes then put the
                    trackList[j] = key; // key value in this slot in the array. This represents the beat
                } else {                // Otherwise instrument is not supposed to play at this moment.
                    trackList[j] = 0;   // so set it to zero.
                }
            }

            makeTracks(trackList);
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 20));
        }
        track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 19));
        // We always want to make sure that there is an event at beat 20, there always is an
        // event at beat 20 (it goes 0 to 19). Other wise the BeatBox might not go the full 20
        // beats before  it starts over. This is kind of a dummy event to prevent early stop
        // when NOTE_ON, NOTE_OFF end much earlier liek in beat 10 or 12.

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeTempo(float tempoMultiplier) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    }
    // This makes events for one instrument at a time, for all 16 beats.
    // So, it might get an int[] for the Bass drum, and each index in the array will 
    // hold either the key of that instrument or a zero. If it's a zero, the instrument
    // isn't supposed to play at that beat. Otherwise, make an event and add it to the track.
    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(NOTE_OFF, 9, key, 100, i+1));
            }
        }        
    }

    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chnl, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
    
}