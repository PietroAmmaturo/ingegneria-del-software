package eredita;

public class Poligono extends Figura implements Measurable {
    protected int numLati;

    public Poligono(int numLati) {
        this.numLati = numLati;
    }

    @Override
    public int measure() {
        return numLati;
    }

    @Override
    public void disegna() {
        System.out.println("Disegna poligono di " + numLati);
    }
}
