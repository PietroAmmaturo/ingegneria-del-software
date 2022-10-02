package esercitazione2.es4.modules;

import java.util.Random;

public class Player {
    private Shape shape;
    final private Random generator;
    final private String name;
    final public Shape favoriteShape;
    public double [] shapesProbabilities;
    private static final double defaultFavoriteShapeProb = 0.6;

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.shape = null;
        this.generator = new Random();
        this.name = name;
        this.favoriteShape = null;
        this.shapesProbabilities = new double[] {(double)1/3, (double)1/3, (double)1/3};
        sumShapesProbabilities();
    }

    public Player(String name, Shape favoriteShape) {
        //uses the constructor defined below
        this(name, favoriteShape, defaultFavoriteShapeProb);
    }

    public Player (String name, Shape favoriteShape, double favoriteShapeProb) {
        this.shape = null;
        this.generator = new Random();
        this.name = name;
        this.favoriteShape = favoriteShape;
        this.shapesProbabilities = new double[3];
        int i = 0;
        for (Shape s : Shape.values()) {
            double p;
            if (s == this.favoriteShape) p = favoriteShapeProb;
            else p = (1-favoriteShapeProb)/2;
            System.out.println(p);
            this.shapesProbabilities[i] = p;
            i++;
        }
        sumShapesProbabilities();
    }

    // turns the probabilities in 3 ranges
    // shapesProbabilities = [0.3, 0.3, 0.4] => [0.3, 0.6, 1]
    private void sumShapesProbabilities() {
        for (int i = 1; i < shapesProbabilities.length-1; i++) shapesProbabilities[i] += shapesProbabilities[i-1];
        shapesProbabilities[shapesProbabilities.length-1] = 1;
    }

    public void throwShape() {
        // generates random double beween 0 and 1
        double prob = this.generator.nextDouble();
        // scans the 3 ranges generated from sumShapesProbabilities
        if (prob < this.shapesProbabilities[0]) this.shape = Shape.values()[0];
        else if (prob < this.shapesProbabilities[1]) this.shape = Shape.values()[1];
        else this.shape = Shape.values()[2];
    }

    public Shape getShape() {
        return shape;
    }
}
