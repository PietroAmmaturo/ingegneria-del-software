package esercitazione2.es3;

import esercitazione2.es3.modules.Player;
import esercitazione2.es3.modules.RpsSimulation;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Federico");
        Player p2 = new Player("Giacomo");
        RpsSimulation.simulateMatch(p1, p2, 3);
    }
}
