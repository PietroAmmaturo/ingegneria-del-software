package concorrenza;

public class BankAccount2 {
    private int balance;

    public BankAccount2(int balance) {
        this.balance = balance;
    }

    // non funziona
    // public synchronized void withdraw(int amount) {
    // while (true) {
    // if (amount < balance) {
    // balance -= amount;
    // break;
    // }
    // }
    // balance -= amount;
    // }

    // funziona ma è sempre attivo! (blocco un thread indefinitivamente)
    // public void withdraw(int amount) {
    // while (true) {
    // synchronized (this) {
    // if (amount < balance) {
    // balance -= amount;
    // break;
    // }
    // }
    // }
    // balance -= amount;
    // }

    public synchronized void withdraw(int amount) throws InterruptedException {
        // uso il while perchè magari anche se avviene notify all non ho abbastanza
        // soldi
        // inoltre java da specifica dice di usare sempre il while (non è detto che i
        // thread vengano risvegliati solo da notifyAll)
        while (amount > balance) {
            this.wait();
            // wait fa rilasciare il lock al thread (si mette in pausa l'esecuzione)
            // il thread va in uno stato speciale dove aspetta che venga notificata la
            // ripresa
        }
        balance -= amount;
        // risveglio TUTTI i thread messi in wait
        this.notifyAll();
    }

    public synchronized void deposit(int amount) throws InterruptedException {
        // assumo che amount < 1000
        // voglio che al massimo sul conto ho 1000
        while (balance + amount > 1000) {
            this.wait();
        }
        balance += amount;
        // risveglio TUTTI i thread messi in wait
        this.notifyAll();
    }

    public synchronized int getBalance() {
        return balance;
    }

}
