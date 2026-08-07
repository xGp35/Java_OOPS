import java.util.concurrent.*;

public class LostUpdate {
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
    int balance = 0;

    public void increment() {
        balance++;
    }
}