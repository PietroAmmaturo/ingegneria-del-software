package exercises.concorrenza.ex20210118;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public synchronized void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public synchronized double getX() {
        return x;
    }

    public synchronized double getY() {
        return y;
    }

    public Vector sum(Vector other) {
        double myX, myY, otherX, otherY = 0;
        synchronized (this) {
            myX = this.x;
            myY = this.y;
        }
        synchronized (other) {
            otherX = other.x;
            otherY = other.y;
        }
        Vector res = new Vector(myX + otherX, myY + otherY);
        return res;

        // Corretto (ma non equivalente)
        // return new Vector(this.getX() + other.getX(), this.getY() + other.getY());
        
        // potrei fare un set tra il get x e il gety
        // si suppongano v1 = (2, 3), v2 = (5,7)
        // v1.sum(v3) arriva a this.getX
        // eseguo v1.set(0, 0)
        // ora this.getY varrà 0
        // il risultato sarà (7, 7)
        // che non è nè la somma di v2 con v1 prima del set nè quella dopo il set
    }
}
