package esercitazione4.es0.ambiguous.esempio1;

public class Main {
    public static void main(String[] args) {
        ExtClass2 x = new ExtClass2();
        //x.m1(new Class2(), new Class2());
        // AMBIGUOUS!
        // DEVE RISALIRE LA GERARCHIA DI UNO DEI DUE PARAMETRI (Class1/Class2, Class1/Class2) E NON SA QUALE PREFERIRE
    }
}
