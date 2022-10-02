package esercitazione2.es1.modules;

import java.util.Random;

public class Coin {
    private Side showingSide;
    final private Random generator;

    public Coin () {
        this.showingSide = null;
        this.generator = new Random(2022);
        toss();
    }

    public Coin(Side s) {
        this.generator = new Random(2022);
        this.showingSide = s;
    }

    public Coin (int seed) {
        this.showingSide = null;
        this.generator = new Random(seed);
    }

    public void toss () {
        if (this.generator.nextDouble() <= 0.5) this.showingSide = Side.HEAD;
        else this.showingSide = Side.TAIL;
    }

    public Side getShowingSide() {
        return showingSide;
    }
}
