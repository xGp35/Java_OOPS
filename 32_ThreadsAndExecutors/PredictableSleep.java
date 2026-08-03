import java.util.concurrent.*;

class PredictableSleep {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(()-> sleepThenPrint());
        System.out.println("back in main");
        executor.shutdown();
    }

    public static void sleepThenPrint() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("top o' the stack");
    }
}