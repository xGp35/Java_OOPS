import java.util.concurrent.*;

public class ClosingTime {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(new LongJob("Long Job"));
        threadPool.execute(new ShortJob("Short Job"));

        threadPool.shutdown();

        try {
            boolean finished = threadPool.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Finished? " + finished);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdownNow();
    }
}

class LongJob implements Runnable {
    private String name;

    public LongJob (String name) {
        this.name = name;
    }

    public void run() {
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            // The JVM does not force the thread to die. So, the recommended pattern is:
            Thread.currentThread().interrupt(); // restore interrupt status
            return;
        }
        System.out.println("my name is, my name is, my name is " + name);
    }
}

class ShortJob implements Runnable {
    private String name;

    public ShortJob (String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("my name is, my name is, my name is " + name);
    }
}