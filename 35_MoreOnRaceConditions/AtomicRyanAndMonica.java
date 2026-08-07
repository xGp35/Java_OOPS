import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicRyanAndMonica {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        SpendingTask ryan = new SpendingTask("Ryan", account, 50);
        SpendingTask monica = new SpendingTask("Monica", account, 100);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(ryan);
        executor.execute(monica);
        executor.shutdown();
    }
}

class SpendingTask implements Runnable {
    private final String shopperName;
    private final BankAccount account;
    private final int amountToSpend;

    SpendingTask(String name, BankAccount account, int amountToSpend) {
        this.shopperName = name;
        this.account = account;
        this.amountToSpend = amountToSpend;
    }

    public void run() {
        goShopping(amountToSpend);
    }

    public void goShopping(int amount) {
        System.out.println(shopperName +" is about to spend");
        account.spend(shopperName, amount);
        System.out.println(shopperName + " finshes spending");
    }
}

class BankAccount {
    private final AtomicInteger balance = new AtomicInteger(100);

    public int getBalance() {
        return balance.get();
    }

    public void spend(String name, int amount) {
        int initialBalance = balance.get();
        if (initialBalance >= amount) {
            boolean success = balance.compareAndSet(initialBalance, initialBalance - amount);
            // The balance will NOT be changed if the initial balance does not match 
            // the actual balance right now.
            // Pass in the balance from when we checked if there
            // initialBalance - amount ->  This is the “spend,” subtracting the amount spent 
            // from the account balance.
            if (!success) {
                System.out.println("Sorry " + name + ", you haven't spent the money.");
            }
        } else {
            System.out.println("Sorry, not enough money in the bank for " + name);
        }
    }
}
