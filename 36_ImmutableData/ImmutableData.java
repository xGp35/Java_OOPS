public final class ImmutableData {
    private final String name;
    private final int value;

    public ImmutableData(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name;}

    public int getValue() { return value;}

    // Immutable objects don't have setters, only getters.
}