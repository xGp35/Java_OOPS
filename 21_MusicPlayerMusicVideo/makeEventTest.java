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