package exercises.concorrenza.ex20200116;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private static List<Double> log = new ArrayList<Double>();
    private double balance;

    public Account() {
        balance = 0.0;
    }

    // lascio il synchronized esterno perchè balanced non è condivisa
    // volendo si può sincronizzare direttamente su log l'intero corpo (come
    // sincronizzarsi sull'intera classe), ma a quel punto non potrei modificare
    // balance di oggetti diversi contemporaneamente
    public synchronized void deposit(double val) {
        balance += val;
        // gli attributi statici sono condivisi da tutta la classe
        // occorre prendere il lock su log (che è condiviso)
        // non basta prenderlo su una singola istanza
        synchronized (log) {
            log.add(val);
        }
    }

    public synchronized void withdraw(double val) {
        balance -= val;
        synchronized (log) {
            log.add(-val);
        }
    }

}
