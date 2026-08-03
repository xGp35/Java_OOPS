class ThreadTester {
    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        // Thread myThread = new Thread(event -> buildAndSetupBeatox())
        myThread.start();
        System.out.println(Thread.currentThread().getName() + ": back in main");
        Thread.dumpStack();
    }
}