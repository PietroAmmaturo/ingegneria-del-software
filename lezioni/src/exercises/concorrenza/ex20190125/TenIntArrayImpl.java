package exercises.concorrenza.ex20190125;

public class TenIntArrayImpl implements TenIntArray {
    private final int array[];
    private int size;

    public TenIntArrayImpl() {
        array = new int[10];
        size = 0;
    }

    @Override
    public synchronized int get(int pos) throws Exception {
        if (pos < 0 || pos >= size) {
            throw new Exception();
        } else {
            return array[pos];
        }
    }

    @Override
    public synchronized void remove() {
        if (size > 0) {
            size--;
            this.notifyAll();
        }
    }

    @Override
    public synchronized void add(int val) {
        while (size == 10) {
            try {
                // se non c'è spazio per un nuovo elemento aspetto (che venga rimosso qualcosa)
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        array[size] = val;
        size++;
    }
}
