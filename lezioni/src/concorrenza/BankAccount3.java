package concorrenza;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount3 {
    // atomicinteger fa tutto lui (si occupa della sincronizzazione di un intero)
    private final AtomicInteger balance;

    public BankAccount3() {
        balance = new AtomicInteger();
    }

    public void withdraw(int amount) throws InterruptedException {
        balance.addAndGet(-amount);
    }

    public void deposit(int amount) throws InterruptedException {
        balance.addAndGet(amount);
    }

    public int getBalance() {
        return balance.get();
    }
}
