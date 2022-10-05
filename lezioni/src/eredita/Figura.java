package eredita;

public abstract class Figura {

    public void disegna() {
        System.out.println("Disegno figura");
    }

    // Una classe abstract puo' avere metodi abstract
    // public abstract void disegna();

    @Override
    public String toString() {
        return "Sono una figura";
    }
}
