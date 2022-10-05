package polimorfismo;

public class Punto3D extends Punto2D {

    private final int z;

    public Punto3D(int x, int y, int z) {
        // occorre usare il costruttore del metodo "genitore", poichè x ed y sono privati
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }
    
    @Override
    public void distanza(Punto2D p) {
        System.out.println("Metodo distanza in 3D con par 2D");
    }

    @Override
    public void distanza(Punto3D p) {
        System.out.println("Metodo distanza in 3D con par 3D");
    }
}
