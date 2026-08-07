import java.util.concurrent.*;

public class RyanAndMonicaTest {
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
        synchronized (account) { // remove this line to get unexpected behaviour
            if (account.getBalance() >= amount) {
                System.out.println(shopperName +" is about to spend");
                account.spend(amount);
                System.out.println(shopperName + " finshes spending");
            } else {
                System.out.println("Sorry, not enough for " + shopperName);
            }
        }
    }
}

class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void spend(int amount) {
        balance = balance - amount;
        if (balance < 0) {
            System.out.println("Overdrawn!");
        }
    }
}