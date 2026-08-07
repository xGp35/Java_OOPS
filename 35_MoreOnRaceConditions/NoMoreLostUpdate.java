// Here we make the increment method synchronized. This keeps the steps of the method,
// The read of balance and the increment of balance as one unbreakable unit.

import java.util.concurrent.*;

public class NoMoreLostUpdate {
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

// Once a thread enters a method, we have to make sure that all the steps in the method
// complete (as one process) before any other thread can enter the method.

class BankAccount {
    int balance = 0;

    public synchronized void increment() {
        balance++;
        // This looks like a single operation but its actually more than one.
        // It's a read of the balance, an increment and update to the balance.
    }
}