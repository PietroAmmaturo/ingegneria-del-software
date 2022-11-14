package concorrenza;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
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

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        // li assume se quelli disponibili sono occupati, li licenzia se stanno senza fare nulla
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> System.out.println("Ciao"));
        Future<Integer> resultFuture = executorService.submit(() -> 2 + 2);
        System.out.println("Conduco la mia vita da main");
        int result = resultFuture.get();
        executorService.shutdown();

        Map<String, Integer> m = new ConcurrentHashMap<>();
        Queue<Integer> queue = new ArrayBlockingQueue<>(4);
        List<Integer> listaNonSync = new ArrayList<>();
        List<Integer> listaSync = Collections.synchronizedList(listaNonSync);
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
