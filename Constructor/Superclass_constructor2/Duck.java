public class Duck extends Animal {
    int size;

    public Duck(int newSize) {
        // The call to super has to be the first call in the subclass if at all present
        super();
        size = newSize;
    }
}

class TestDuck {
    public static void main(String[] args){
        Duck ducky = new Duck(20);
        System.out.println("ducky is this big -- " + ducky.size);
    }
}