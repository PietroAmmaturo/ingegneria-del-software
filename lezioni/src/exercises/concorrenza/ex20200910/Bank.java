package exercises.concorrenza.ex20200910;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<String> accName;
    private List<Double> accBalance;

    public Bank() {
        accName = new ArrayList<String>();
        accBalance = new ArrayList<Double>();
    }

    public void addAccount(String clientName) throws Exception {
        synchronized (accName) {
            synchronized (accBalance) {
                if(accName.contains(clientName)) throw new Exception();
                accName.add(clientName) ;
                accBalance.add (0.0) ;
            }
        }
    }

    public double getBalance (String clientName) throws Exception {
        synchronized (accName) {
            synchronized (accBalance) {
                int pos = accName.indexOf(clientName);
                if (pos == -1) throw new Exception();
                return accBalance.get(pos);
            }
        }
    }

    public void deposit (String clientName , double amount) throws Exception {
        synchronized (accName) {
            synchronized (accBalance) {
                int pos = accName.indexOf(clientName);
                if (pos==-1) throw new Exception();
                double newBalance = accBalance.get(pos) + amount;
              accBalance.set(pos, newBalance);
            }
        }
    }

    public void withdraw(String clientName, double amount) throws Exception {
        synchronized (accName) {
            synchronized (accBalance) {
                int pos = accName.indexOf(clientName);
                if (pos == -1) throw new Exception();
                double newBalance = accBalance.get(pos) - amount;
                accBalance.set(pos, newBalance);
            }
        }
    }
}