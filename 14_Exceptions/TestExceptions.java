public class TestExceptions {
    public static void main(String[] args) {
        String test = "yes";
        try {
            System.out.println("start try");
            doRisky(test);
            System.out.println("end try");
        } catch (ScaryException se) {
            System.out.println("scary exception");
        } finally {
            System.out.println("finally");
        }
        System.out.println("end of main");
    }

    // Why is the following method doRisky declared as static??
    // The reason is simply that main() is also static. Inside a static method, 
    // you cannot directly call an instance method because there is no object (this) to call it on.
    // You would first need to create an object:
    // TestExceptions t = new TestExceptions();
    // t.doRisky(test);

    static void doRisky(String test) throws ScaryException {
        System.out.println("start risky");
        if ("yes".equals(test)) {
            throw new ScaryException();
        }
        System.out.println("end risky");
    }
}

class ScaryException extends Exception {}
