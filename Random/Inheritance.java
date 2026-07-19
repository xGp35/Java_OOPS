// Inheritance in Java is declared using "extends"

// Implicit constructor
public abstract class Animal {
    protected int numberOfLegs;

    public void walk() {...}
}
// Explicit constructor
public abstract class Animal {
    protected int numberOfLegs;

    public Animal( int legs) {
        this.numberOfLegs = legs;
    }
}
