// Here we think more object oriented. Before, the balance checking operation (balance >= amount)
// was inside the goShopping() method. But who owns the balance? The Bank Account class.
// So we take that operation out of the goShopping() method and put it inside the spend method.
// Think of a ATM. Do you do this
// Step 1: Check Bank database, Step 2: If enough balance: Tell ATM to dispense cash.
// NOOO. You simply tell the ATM to dispense money. It's the job of the ATM machine to check, the 
// balance, if the amount you want to spend (which you gave as a parameter) is less than the 
// bank account balance, then the ATM dispenses the money, else it errors out- saying not enough money
import java.util.concurrent.*;

public class ImprovedRyanAndMonicaTest {
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
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public synchronized void spend(String name, int amount) {
        if ( balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Sorry, not enough money in the bank for " + name);
        }
    }
}

// class BankAccount {
//     private int balance = 100;

//     public int getBalance() {
//         return balance;
//     }

//     public synchronized void spend(String name, int amount) {
//         if (balance >= amount) {
//             balance = balance - amount;
//             if ( balance < 0) {
//                 System.out.println("Overdrawn!");
//             }
//         } else {
//             System.out.println("Sorry, not enough money in the bank for" + name);
//         }
//     }
// }