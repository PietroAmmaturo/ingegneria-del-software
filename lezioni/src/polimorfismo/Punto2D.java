package polimorfismo;

public class Punto2D {

    private final int x;

    private final int y;

    public Punto2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void distanza(Punto2D p) {
        System.out.println("Metodo distanza in 2D con par 2D");
    }

    public void distanza(Punto3D p) {
        System.out.println("Metodo distanza in 2D con par 3D");
    }
}
