import java.awt.Color;

class Mini extends Car {
    private Color color;

    public Mini(){
        this(Color.RED); // if no arguments are provided then assign default color RED
    }

    public Mini(Color c) {
        super("Mini");
        color = c;
    }
}

