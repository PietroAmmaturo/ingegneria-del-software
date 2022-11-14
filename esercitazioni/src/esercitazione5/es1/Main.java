package esercitazione5.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Couple> data = new ArrayList<Couple>();
        data.add(new Couple(1, 2));
        data.add(new Couple(-1, 8));
        data.add(new Couple(0, 10));
        data.add(new Couple(-4, 1));

        //
        int result =
                // trasformo l'arraylist in uno stream
                data.stream()
                        // trasformo lo stream precedente in uno stream che ha solo le coppie il cui
                        // primo valore è >= 0
                        .filter(c -> c.val1 >= 0)
                        // trasformo lo stream precedente in uno stream di interui
                        .map(c -> c.val2)
                        // scorro lo stream ed applico la funzione (total, value) -> total + value man
                        // mano che lo scorro, dove total inizia con 0
                        .reduce(0, (total, value) -> total + value);
        System.out.println(result);

        // ALTRI MODI PER RISOLVERE L'ESERCIZIO SENZA UTILIZZARE LO "ZUCCHERO
        // SINTATTICO"
        // FARE RIFERIMENTO ALLA SOLUZIONE PRECEDENTE PER UNA BUONA SOLUZIONE AL TEMA
        // D'ESAME
        int result1 = data.stream().filter(new Predicate<Couple>() {
            @Override
            public boolean test(Couple couple) {
                return couple.val1 >= 0;
            }
        }).map(new Function<Couple, Integer>() {
            @Override
            public Integer apply(Couple couple) {
                return couple.val2;
            }
        }).reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer total, Integer value) {
                return total + value;
            }
        });
        System.out.println(result1);

        int result2 = data.stream()
                .filter(new MyPredicate())
                .map(new MyFunction())
                .reduce(0, new MyBinaryOperator());
        System.out.println(result2);
    }
}

class MyPredicate implements Predicate<Couple> {
    @Override
    public boolean test(Couple couple) {
        return couple.val1 >= 0;
    }
}

class MyFunction implements Function<Couple, Integer> {
    @Override
    public Integer apply(Couple couple) {
        return couple.val2;
    }
}

class MyBinaryOperator implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer o, Integer o2) {
        return o + o2;
    }
}
