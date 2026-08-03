// To get started - we'll run only one job in addition to our main class
import java.util.concurrent.*;

class ExecutorTester {
    public static void main(String[] args) {
        Runnable job = new MyRunnable();
        // Executor service is like a Manager for workers (threads)
        // It can create new threads and assign work to them.
        // We give out job to the Executor service, the executor service decides which worker to
        // give the work to. If there is a single worker, like here, that will do all jobs sequentially.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(job);

        System.out.println(Thread.currentThread().getName() + ": back in main");
        Thread.dumpStack();
        executor.shutdown(); // Important to stop the Executor Service
    }
}