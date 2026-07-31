class MyOuterClass {

    private int x;

    MyInnerClass inner = new MyInnerClass();

    public void doStuff() {
        inner.go(); // call a method on the inner class
    }

    class MyInnerClass {
        void go() {
            // An inner class can use all the methods and variables of the outer class
            // even the private ones.
            x = 42;
            // The inner class gets to use those variables and methods just as if the methods 
            // and variables were declared within the inner class.
        }
    }
}