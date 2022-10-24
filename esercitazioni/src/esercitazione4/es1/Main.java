package esercitazione4.es1;

public class Main {
    public static void main(String[] args) {
        Device d1 = null, d2 = new Device();
        Watch w = new Smartwatch();
        Smartwatch sw = new Smartwatch();
        Person p = new Person("Marco");
        Professor pp = new FullProfessor("Andrea");
        FullProfessor fp;

        d1 = sw;
        // d1 è dichiarato Device
        // sw è dichiarato Smartwatch
        // Smartwatch è sottoclasse di Device

        // fp = pp;
        // fp è dichiarato FullProfessor
        // pp è dichiarato Professor
        // ! ERRORE A COMPILE TIME, non posso assegnare alla sottoclasse la superclasse

        System.out.println("p.buy(d1, 15);");
        p.buy(d1, 15);
        // p S/D: Person
        // d1 S: Device, D: Smartwatch
        // Person (tipo statico di p) ha una sola versione di buy con parametri (Device, double)
        // Il tipo dinamico e il tipo statico di p coincidono, non devo analizzare gli override
        // d1 ha tipo statico Device
        // 15 è int ma può essere convertito a double
        // Si chiama la versione con parametri (Device, double) della classe Person

        p = pp;
        // p è dichiarato come Person
        // pp è dichiarato come FullProfessor
        // FullProfessor è sottoclasse di Person (anche se non diretta)

        System.out.println("\np.buy(d1, 15);");
        p.buy(d1, 15);
        // p S: Person, D: FullProfessor
        // Person (tipo statico di p) ha una versione di buy con parametri (Device, double)
        // Professor (nella gerarchia del tipo dibnamico di p) non fa override
        //      del metodo con parametri (Device, double)
        // FullProfessor (tipo dinamico di p) non fa override del metodo con parametri (Device, double)
        // d1 ha tipo statico Device
        // 15 è int e può essere assegnato al parametro double
        // Si chiama la versione con parametri (Device, double) della classe Person

        System.out.println("\npp.buy(w, 15);");
        pp.buy(w, 15);
        // pp S: Professor, D: FullProfessor
        // w S: Watch, D: Smartwatch
        // Professor (tipo statico di pp) ha una versione di buy con parametri (Device, int)
        // Professor eredita da Person la versione di buy con parametri (Device, double)
        // FullProfessor (tipo dinamico di pp) non fa override delle due versioni sopra
        // w ha tipo statico Watch, che è sottoclasse di Device
        // 15 è int, può essere assegnato al parametro double
        // Si chiama la versione di Professor con parametri (Device, int)

        fp = new FullProfessor("Luca");
        // fp è dichiarato FullProfessor

        System.out.println("\nfp.buy(w, 15.0);");
        fp.buy(w, 15.0);
        // fp S/D FUllProfessor
        // w S: Watch, D: Smartwatch
        // FullProfessor (tipo statico di fp) ha una versione di buy con parametri (Smartwatch, int)
        // FullProfessor eredita da Professor la versione di buy con parametri (Device, int)
        // FullProfessor eredita da Person la versione di buy con parametri (Device, double)
        // w ha tipo statico Watch, può essere assegnato anche a Device, ma non a Smartwatch
        // 15.0 è double, non può essere assegnato a int
        // Si chiama la versione ereditata da Person con parametri (Device, double)

        System.out.println("\nfp.buy(w, 15);");
        fp.buy(w, 15);
        // fp S/D FUllProfessor
        // w S: Watch, D: Smartwatch
        // FullProfessor (tipo statico di fp) ha una versione di buy con parametri (Smartwatch, int)
        // FullProfessor eredita da Professor la versione di buy con parametri (Device, int)
        // FullProfessor eredita da Person la versione di buy con parametri (Device, double)
        // w ha tipo statico Watch, può essere assegnato anche a Device, ma non a Smartwatch
        // 15 è int, può essere assegnato anche a double
        // Si possono scegliere: Professor: (Device, int) e Person: (Device, double)
        // Si sceglie quello con versione int
    }
}
