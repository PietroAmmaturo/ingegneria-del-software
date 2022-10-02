package esercitazione2.es3.modules;

import java.util.Random;

public class Player {
    private Shape shape;
    final private Random generator;
    final private String name;

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.shape = null;
        this.generator = new Random();
        this.name = name;
    }

    public void throwShape() {
        switch (this.generator.nextInt(3)) {
            case 0 -> this.shape = Shape.PAPER;
            case 1 -> this.shape = Shape.ROCK;
            case 2 -> this.shape = Shape.SCISSORS;
        }
    }

    public Shape getShape() {
        return shape;
    }
}
