package exercises.concorrenza.ex20190626;

public class LongSequence {
    private long[] data;

    public LongSequence(int size) {
        data = new long[size];
        for(int i=0; i<size; i++) data[i]=-1;
    }

    public long get(int pos)  throws InterruptedException {
        long result;
        synchronized(data) {
            while(data[pos]<0) {
                data.wait();
            }
            result = data[pos];
            data[pos] = -1;
            data.notifyAll();
        }
        return result;
    }

    public void set(int pos, long val) throws InterruptedException {
        synchronized(data) {
            while(data[pos]>=0) data.wait();
            data[pos] = val;
            data.notifyAll();
        }
    }

    public void setAllAsync(long val) {
        // creo un thread che serve per eseguire le operazioni
        new Thread(() -> {
            // prendo il lock su data
            synchronized (data) {
                // setto tutti i valori a val, in maniera asincrona (non lascio il lock su data finchè non ho finito)
                for (int i = 0; i < data.length; i++) {
                    data[i] = val;
                }
                // avverto chi era in wait che ho finito
                data.notifyAll();
            }
        }).start();
    }

    public int getSize() {
        return data.length;
    }
}
/* alternativa a sync data (sync this)
public class LongSequence {
    private long[] data;

    public LongSequence2(int size) {
        data = new long[size];
        for(int i=0; i<size; i++) data[i]=-1;
    }

    public long get(int pos)  throws InterruptedException {
        long result;
        synchronized(this) {
            while(data[pos]<0) {
                wait();
            }
            result = data[pos];
            data[pos] = -1;
            data.notifyAll();
        }
        return result;
    }

    public void set(int pos, long val) throws InterruptedException {
        synchronized(this) {
            while(data[pos]>=0) data.wait();
            data[pos] = val;
            notifyAll();
        }
    }

    public void setAllAsync(long val) {
        // creo un thread che serve per eseguire le operazioni
        new Thread(() -> {
            // prendo il lock su data
            synchronized (LongSequence.this) {
                // setto tutti i valori a val, in maniera asincrona (non lascio il lock su data finchè non ho finito)
                for (int i = 0; i < data.length; i++) {
                    data[i] = val;
                }
                // avverto chi era in wait che ho finito
                LongSequence.this.notifyAll();
            }
        }).start();
    }

    public int getSize() {
        return data.length;
    }
}
*/