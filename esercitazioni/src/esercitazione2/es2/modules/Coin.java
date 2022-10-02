package esercitazione2.es2.modules;

import java.util.Random;

public class Coin {
    private Side showingSide;
    final private Random generator;
    final private double pHead;
    final private static int seed = 2022;

    public Coin () {
        this.showingSide = null;
        this.generator = new Random(seed);
        this.pHead = 0.5;
    }

    public Coin (double pHead) {
        this.showingSide = null;
        this.generator = new Random(seed);
        this.pHead = pHead;
    }

    public void toss () {
        if (this.generator.nextDouble() <= pHead) this.showingSide = Side.HEAD;
        else this.showingSide = Side.TAIL;
    }

    public Side getShowingSide() {
        return showingSide;
    }
}
