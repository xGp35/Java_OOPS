public class RunTester {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        runnable.run();
        System.out.println(Thread.currentThread().getName() + ":back in main");
        Thread.dumpStack();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println(Thread.currentThread().getName() + ": bottom o' the stack");
        Thread.dumpStack();
    }
}