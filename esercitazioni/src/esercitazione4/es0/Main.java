package esercitazione4.es0;

public class Main {
    public static void printClass(Class1 p) {
        System.out.println("PARAMETER: Class1");
        System.out.println("DYNAMIC: "+p.getClass().getName());
    }

    public static void printClass(Class2 p) {
        System.out.println("PARAMETER: Class2");
        System.out.println("DYNAMIC: "+p.getClass().getName());
    }

    public static void main(String[] args) {
        Class1 c1_c1 = new Class1();
        Class1 c1_c2 = new Class2();
        Class2 c2_c2 = new Class2();

        System.out.println("\nc1_c1");
        printClass(c1_c1);

        System.out.println("\nc1_c2");
        printClass(c1_c2);
        // sceglie il metodo sulla base del tipo statico dei parametri

        System.out.println("\nc2_c2");
        printClass(c2_c2);

        System.out.println("\nCAST");
        printClass((Class2)c1_c2);
        // facendo il cast cambiamo il tipo statico

        System.out.println("\nNEW");
        printClass(new Class2());

        System.out.println("\nCAST NEW");
        printClass((Class1)new Class2());
        // facendo il cast cambiamo il tipo statico

        System.out.println("\nc3.m1");
        Class3 c3 = new Class3();
        c3.m1();
        // chiama i metodi super della classe
        // super si valuta sempre sulla classe su cui viene eseguito il codice

        System.out.println("\nc1_c1.m2");
        c1_c1.m2();
        System.out.println("\nc2_c2.m2");
        c2_c2.m2();
        System.out.println("\nc1_c2.m2");
        c1_c2.m2();
        // la chiamata ai metodi è sempre dinamicamente sull'oggetto
        // anche se stiamo eseguendo il codice della superclasse
        // in caso di overriding si esegue il metodo della sottoclasse

        Class2 x = new Class2();
        Class1 y = (Class1)x;
        System.out.println("\nDynamic class: "+y.getClass().getName());
        // il tipo dinamico non cambia anche a seguito del cast
        // il cast agisce sul tipo statico


        Class2 z = (Class2)c1_c1;
        // l'editor ci dà il warning ma non si ha errore a compile time
        // ci aspettiamo un errore a run time

    }
}
