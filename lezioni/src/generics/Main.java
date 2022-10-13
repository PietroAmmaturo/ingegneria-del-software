package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Pair<String> p = new Pair<String>("Pippo", "Pluto");
        Pair<Integer> p1 = new Pair<>(10, 20);
        Pair<Double> p2 = new Pair<>(10.0, 20.0);

        DifferentPair<String, Integer> d1 = new DifferentPair<String, Integer>("Pippo", 10);

        ArrayList<String> a = new ArrayList<>();
        a.add("aaa");
        a.get(0);

        // uso tipo list perchè è preferibile usare il tipo statico più alto
        List<String> a1 = new LinkedList<>();
        // non va bene: List<Object> a1 = new LinkedList<String>();
        // non c'è ereditarietà all'interno delle parentesi

        Set<String> a2 = new HashSet<>();

        Map<String, Integer> m = new HashMap<>();
        m.put("Nome", 12345);
        int tel = m.get("Nome");

        // cosa scrivo
        for (String s : a1) {
            System.out.println(s);
        }
        // cosa java scrive per me
        Iterator<String> it = a1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // cosa scrivo
        Pair<String> pp = new Pair<>("A", "B");
        for (String s : pp) {
            System.out.println(s);
        }

        // cosa java scrive per me
        Iterator<String> ppIt = pp.iterator();
        while (ppIt.hasNext()) {
            System.out.println(ppIt.next());
        }
    }
}
