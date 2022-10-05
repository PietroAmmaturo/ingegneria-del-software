package eredita;

public class Main {
    public static void main(String[] args) {
        Cerchio c = new Cerchio();
        c.disegna();
        Poligono p = new Poligono(3);
        p.disegna();
        Quadrato q = new Quadrato();
        q.disegna();
        System.out.println(q.toString());
        Measurable m = new Quadrato();
        m.measure();
    }
}
