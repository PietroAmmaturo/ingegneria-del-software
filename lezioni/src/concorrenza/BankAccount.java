package concorrenza;

public class BankAccount {
    private float balance;

    public BankAccount(float startingBalance) {
        balance = startingBalance;
    }

    // voglio che deposit e withdraw siano in mutua esclusione

    // prima di eseguire deposit devo finire di eseguire le altre funzioni che sono
    // synchronized
    public synchronized void deposit(float amount) {
        // non è un istruzione atomica
        // equivale a 3 istruzioni assembly almeno
        balance += amount;
    }

    // prima di eseguire withdraw devo finire di eseguire le altre funzioni che sono
    // synchronized
    public synchronized void withdraw(float amount) {
        // non è un istruzione atomica
        // equivale a 3 istruzioni assembly almeno
        balance -= amount;
    }

    // magari voglio sincronizzare solo alcune parti del metodo
    public void deposit2(float amount) {
        // acquisisco il lock di this
        synchronized (this) {
            balance += amount;
        }
    }

    // Esempio di deadlock!
    // se 2 account si fanno 2 bonifici a vicenda in contemporanea
    public synchronized void transfer(int amount, BankAccount destination) {
        balance -= amount;
        // destination.balance += amount; non va bene!, non ho in mano il lock
        // dell'altra istanza (potrei star modificando balance durante un deposit)
        // uso synchronized per acquisire il lock di destination
        synchronized (destination) {
            destination.balance += amount;
        }
        // oppure uso direttamente il metodo deposit
        // destination.deposit(amount);
    }

    // Esempio di deadlock!
    // se 2 account si fanno 2 bonifici a vicenda in contemporanea
    public void transferWithoutDeadLock(int amount, BankAccount destination) {
        // è diverso da prima! potrei avere problemi (faccio 10 tranfer e il mio conto
        // va in negativo senza sapere quale ranfer lo ha causato)
        // infatti potrei prelevare dal mio account l'amount di ognuno e solo dopo
        // tentare il trasferimento
        synchronized (this) {
            balance -= amount;
        }
        synchronized (destination) {
            destination.balance += amount;
        }
        // equivalente a
        // this.withdraw(amount);
        // destination.deposit(amount);
    }

    // prima di eseguire getBalance devo finire di eseguire le altre funzioni che
    // sono synchronized
    public synchronized float getBalance() {
        return this.balance;
    }

}
