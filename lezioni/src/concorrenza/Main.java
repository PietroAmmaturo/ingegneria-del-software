package concorrenza;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // for (int i = 0; i < 1000; i++) {
        // new MyThread1(i).start();
        // }
        // System.out.println("Ciao");
        // for (int i = 0; i < 1000; i++) {
        // Runnable r = new MyRunnable1(i);
        // Thread t = new MyThread1(i);
        // t.start();
        // }
        // System.out.println("Ciao ancora");
        // for (int i = 0; i < 1000; i++) {
        // // serve un final poichè il compilatore sa che i è una variabile mutabile
        // final int num = i;
        // // mentre faccio il thread guardo la cella di num (che ogni volta è una
        // // variabile diversa), non posso mettere i
        // // se ci fosse direttamente i starei accedendo ad una cella di memoria che
        // sta
        // // mutando
        // // (il valore di i viene modificato in contemporanea alla creazione del
        // thread)
        // new Thread(() -> System.out.println(num));
        // }
        BankAccount account = new BankAccount(0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                // t1 fa tutte le deposit sequenzialmente
                account.deposit(1);
            }
        });

        Thread t2 = new Thread(() -> {
            // t2 fa tutte le withdraw sequenzialmente
            for (int i = 0; i < 1000; i++) {
                account.withdraw(1);
            }
        });
        // inizio ad eseguire t1 e t2 in maniera sincrona
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final value: " + account.getBalance());
    }
}

class MyThread1 extends Thread {
    private final int num;

    public MyThread1(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void run() {
        System.out.println(num);
    }
}

class MyRunnable1 implements Runnable {
    private final int num;

    public MyRunnable1(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void run() {
        System.out.println(num);
    }
}
