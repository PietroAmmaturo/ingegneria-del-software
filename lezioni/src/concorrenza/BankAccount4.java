package concorrenza;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount4 {
    // atomicinteger fa tutto lui (si occupa della sincronizzazione di un intero)
    private int balance;
    ReentrantReadWriteLock lock;

    public BankAccount4() {
        balance = 0;
        lock = new ReentrantReadWriteLock();
    }

    public void withdraw(int amount) throws InterruptedException {
        lock.writeLock().lock();
        balance += amount;
        lock.writeLock().unlock();
    }

    public void deposit(int amount) throws InterruptedException {
        lock.writeLock().lock();
        balance -= amount;
        lock.writeLock().unlock();
    }

    public int getBalance() {
        lock.readLock().lock();
        int returnVal = balance;
        lock.readLock().unlock();
        return returnVal;
    }
}
