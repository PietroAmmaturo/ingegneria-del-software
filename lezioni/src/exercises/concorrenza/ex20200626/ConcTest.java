package exercises.concorrenza.ex20200626;

public class ConcTest {
    private double x, y;
    public ConcTest(double a) {
        x = a;
        y = a;
    }

    public synchronized void setX(double x) {
        this.x = x;
    }

    public synchronized double getX() {
        return x;
    }

    public synchronized double getY() {
        return y;
    }

    public synchronized void waitForEq() throws InterruptedException {
        while(x!=y) {
            wait ();
        }
    }
}
