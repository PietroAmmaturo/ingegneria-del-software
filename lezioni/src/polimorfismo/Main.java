package polimorfismo;

public class Main {
    public static void main(String[] args) {
        // x staticamente è un punto2D,
        // x dinamicamente è un punto2D,
        Punto2D x = new Punto2D(0, 0);
        // y staticamente è un punto2D,
        // y dinamicamente è un punto3D,
        Punto2D y = new Punto3D(0, 0, 0);
        // z staticamente è un punto2D,
        // z dinamicamente è un punto3D,
        Punto3D z = new Punto3D(0, 0, 0);
        // Errore! Punto3D w = new Punto2D();

        // il caso di overloading (scelta del metodo in base ai parametri) vene risolto
        // staticamente
        // il caso di overriding (sovrascrizione del metodo dato il chiamante) viene risolto
        // dinamicamente, e SOLO DOPO L'OVERLOADING, in base alla signature del metodo scelto dal precedente overloading

        // ipotizziamo di non aver definito distanza(Punto3D p) per i Punto2D
        // se ho tipo statico Punto2D (come nel caso di y),
        // il compilatore sceglie distanza(Punto2D p) anche se z è Punto3D
        // (non essendoci un metodo particolare distanza(Punto3D p) per i Punto2D,
        // viene scelto il più adatto essendo Punto3D una sottoclasse di Punto2D)
        // a questo punto, quando avviene l'overriding, il metodo distanza(Punto2D p) è stato già scelto,
        // pertanto viene sovrascritto dal metodo distanza(Punto2D p) del punto3D (anche se in punto3D esiste un metodo più specifico)

        // x è punto2D sia staticamente che dinamicamente
        // x.metodo accede ai metodi di un punto2D

        // x è dichiarato staticamente come un punto2D,
        x.distanza(x);
        // y come parametro conta come punto2D (overloading)
        x.distanza(y);
        // z è dichiarato staticamente come un punto3D,
        x.distanza(z);

        // y è punto2D staticamente e punto3D dinamicamente
        // y.metodo accede ai metodi di un punto3D (overriding),

        // x è dichiarato staticamente come un punto2D,
        y.distanza(x);
        // y come parametro conta come punto2D (overloading)
        y.distanza(y);
        // z è dichiarato staticamente come un punto3D,
        y.distanza(z);

        // z è punto3D sia staticamente che dinamicamente
        // z.metodo accede ai metodi di un punto3D

        // x è dichiarato staticamente come un punto2D,
        z.distanza(x);
        // y come parametro conta come punto2D (overloading)
        z.distanza(y);
        // z è dichiarato staticamente come un punto3D,
        z.distanza(z);

        Utils.stampaXeY(x);
    }
}
