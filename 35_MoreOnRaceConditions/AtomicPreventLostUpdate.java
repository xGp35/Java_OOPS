// I am not inplementing A new atomic Variable/Object type. This is just a easy name
// to know this code is about Atomic variables.
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class AtomicPreventLostUpdate {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        // If you add more threads you might see even more missing updates

        BankAccount account = new BankAccount();
        for (int i = 0; i < 1000; i++) {
            pool.execute(() -> account.increment());
        }
        pool.shutdown();
        try {
            if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("balance = " + account.balance);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}

class BankAccount {
    AtomicInteger balance = new AtomicInteger(0);

    public void increment() {
        balance.incrementAndGet();
        // incrementAndGet atomically adds one to the value. Even its used by multiple 
        // threads, it will safely increase the value by one in a single operation. This
        // is in contrast to balance++, which is not a single operation.
    }
    
}