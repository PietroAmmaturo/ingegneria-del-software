package esercitazione4.es0.ambiguous.esempio2;

public class Main {
    public static void m1 (Class1 x, int y) {
        System.out.println("CLASS1 INT");
    }

    public static void m1 (Class2 x, double y) {
        System.out.println("CLASS2 DOUBLE");
    }

    public static void m1 (Class1 x) {
        System.out.println("CLASS1");
    }

    public static void m1 (Class2 x) {
        System.out.println("CLASS2");
    }

    public static void main(String[] args) {
        m1(new Class2(), 15.0);
        m1(new Class1(), 15);
        // m1(new Class2(), 15);
        // AMBIGUOUS!
        // DEVE RISALIRE LA GERARCHIA DI UNO DEI DUE PARAMETRI (Class1/Class2, int/double) E NON SA QUALE PREFERIRE
        double x = 15;
        m1(new Class2(), x);
        m1(new Class1());
        m1(new Class2()); // NON DÀ ERRORE PERCHÈ PUÒ RISALIRE LA GERARCHIA
    }
}
