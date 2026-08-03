// Countdown Latch is a barrier synchronizer. 
// Barriers are mechanisms to allow threads to co-ordinate with each other.

import java.util.concurrent.*;

class PredictableLatch {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(1);

        executor.execute(() -> waitForLatchThenPrint(latch));

        System.out.println("back to main");
        latch.countDown();

        executor.shutdown();
    }
    private static void waitForLatchThenPrint(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("top o' the stack");
    }
}