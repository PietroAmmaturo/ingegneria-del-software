package esercitazione2.es4;

import esercitazione2.es4.modules.Player;
import esercitazione2.es4.modules.RpsSimulation;
import esercitazione2.es4.modules.Shape;

public class Main {
    public static void main(String[] args) {
        Player f = new Player("Federico");
        Player g = new Player("Giacomo", Shape.PAPER);
        RpsSimulation.simulateMatch(f, g, 5);
    }
}
