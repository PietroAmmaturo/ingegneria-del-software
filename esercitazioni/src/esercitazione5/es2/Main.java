package esercitazione5.es2;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void numeroPari(final List<Integer> numeri) {
        Integer found = null;
        for (Integer i : numeri) {
            if (i % 2 == 0) {
                found = i;
                break;
            }
        }
        if (found != null) {
            System.out.println("Il primo numero pari " + found);
        } else {
            System.out.println("Nessun numero pari!");
        }
    }

    public static void numeroPariFunctional(final List<Integer> numeri) {
        Optional<Integer> trovato = numeri.stream().filter(n -> n % 2 == 0).findFirst();

        if (trovato.isPresent()) {
            System.out.println("Il primo numero pari " + trovato.get());
        } else {
            System.out.println("Nessun numero pari!");
        }

//        SUGGERIMENTO DEL NOSTRO AMICO MATTIA:
//        trovato.ifPresent(x -> System.out.println("Il primo numero pari "+x));
//        if (trovato.isEmpty()) System.out.println("Nessun numero pari!");

        // PER CHI MI HA CHIESTO A LEZIONE:
        // Non posso fare:
        //      System.out.println(trovato.flatMap(x -> "Il primo numero pari " + x).orElse("Nessun numero pari!"));
        // Perchè la flatMap deve ritornare un Optional di Integer
    }

    public static void main(String[] args) {
        List<Integer> numeri = List.of(1, 3, 5, 7, 11, 2, 4, 6, 3, 5);
        numeroPari(numeri);
        numeroPariFunctional(numeri);

        System.out.println();
        List<Integer> numeri2 = List.of(1, 3, 5, 7, 11, 3, 5);
        numeroPari(numeri2);
        numeroPariFunctional(numeri2);
    }
}
