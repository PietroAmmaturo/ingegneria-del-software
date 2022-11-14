package exercises.concorrenza.ex20210215;

public class Matrix {
    private double [][] data ;
    private int size ;

    public Matrix ( int size ) {
        this.size = size ;
        data = new double[size][size];
    }

    public synchronized double get(int row, int column) {
        return data[row][column];
    }

    public synchronized void set (int row, int column, double value) {
        data[row][column] = value;
    }

    public synchronized void add ( Matrix m) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                data[r][c] += m.data[r][c];
            }
        }
    }

    public synchronized void clear() {
        for(int r=0; r<size; r++) {
            for(int c=0; c<size; c++) {
                data[r][c] = 0;
            }
        }
    }
}
