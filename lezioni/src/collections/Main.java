package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();

        s1.add("Pippo");
        s1.add("Pluto");
        boolean res = s1.contains("Pippo");
        int size = s1.size();
        s1.remove("Pippo");
        for (String s : s1) {
            System.out.println(s);
        }

        Set<Object> s2 = new HashSet<>();
        s2.add("Pippo");
        for (Object s : s2) {
            System.out.println(s.toString());
        }

        List<String> l1 = new ArrayList<>(5);
        l1.add("Pippo");
        l1.set(0, "Pluto");
        String res1 = l1.get(8);
        for (String s : l1) {
            System.out.println(s);
        }

        Map<String, Integer> m1 = new HashMap<>();
        m1.put("Ale", 34989);
        m1.put("Pippo", 123);
        // sovrascrivo il numero telefonico di Pippo
        m1.put("Pippo", 234);
        int numeroDiPippo = m1.get("Pippo");
        for (String s : m1.keySet()) {
            System.out.println("key:" + s + ", value: " + m1.get(s));
        }
        for (Entry<String, Integer> e : m1.entrySet()) {
            System.out.println("key:" + e.getKey() + ", value: " + e.getValue());
        }
    }
}
