package esercitazione5.es3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exam {
    public static List<Integer> findMyIntegers(List<Integer> aList, Predicate<Integer> aPredicate) {
        BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> onlyMine;
        // definisco una funzione onlyMine che:
        onlyMine = (myListOfInt, myPredicate) -> myListOfInt
                // trasforma la lista in uno stream per eseguire azioni funzionalmente
                .stream()
                // esegue il filtering dello stream secondo il predicato
                .filter(myPredicate)
                // riconverto li stream in una lista
                .collect(Collectors.toList());
        // applica la funzione onlyMine ai parametri
        return onlyMine.apply(aList, aPredicate);
    }

    public static void main(String[] s) {
        List<Integer> startingList = Arrays.asList(1, 7, 4, 6, 8, 9);

        Predicate<Integer> predicate = x -> x % 2 == 0;
        List<Integer> finalList = findMyIntegers(startingList, predicate);
        System.out.println(finalList);

        // ALTRI MODI PER RISOLVERE L'ESERCIZIO SENZA UTILIZZARE LO "ZUCCHERO
        // SINTATTICO"
        // FARE RIFERIMENTO ALLA SOLUZIONE PRECEDENTE PER UNA BUONA SOLUZIONE AL TEMA
        // D'ESAME
        Predicate<Integer> predicate1 = new MyPredicate();
        List<Integer> finalList1 = findMyIntegers1(startingList, predicate1);
        System.out.println(finalList1);

        Predicate<Integer> predicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        List<Integer> finalList2 = findMyIntegers2(startingList, predicate2);
        System.out.println(finalList2);
    }

    // ALTRI MODI PER RISOLVERE L'ESERCIZIO SENZA UTILIZZARE LO "ZUCCHERO
    // SINTATTICO"
    // FARE RIFERIMENTO AL METODO findMyIntegers1 PER UNA BUONA SOLUZIONE AL TEMA
    // D'ESAME
    public static List<Integer> findMyIntegers1(List<Integer> aList, Predicate<Integer> aPredicate) {
        BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> onlyMine;
        onlyMine = new MyBiFunction();
        return onlyMine.apply(aList, aPredicate);
    }

    public static List<Integer> findMyIntegers2(List<Integer> aList, Predicate<Integer> aPredicate) {
        BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> onlyMine;

        onlyMine = (myListOfInt, myPredicate) -> myListOfInt.stream().filter(myPredicate).collect(Collectors.toList());

        onlyMine = new BiFunction<List<Integer>, Predicate<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers, Predicate<Integer> integerPredicate) {
                return integers.stream().filter(integerPredicate).collect(Collectors.toList());
            }
        };
        return onlyMine.apply(aList, aPredicate);
    }
}

class MyPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
}

class MyBiFunction implements BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> {
    @Override
    public List<Integer> apply(List<Integer> integers, Predicate<Integer> integerPredicate) {
        return integers.stream().filter(integerPredicate).collect(Collectors.toList());
    }
}
