package esercitazione2.es2.modules;

public final class CoinFairnessTest {
    private static final int N = 2000;
    private static final double defaultTolerance = 0.05;

    private CoinFairnessTest() {};

    public static boolean isFair (Coin c, double tolerance) {
        int heads = 0;
        for (int i = 0; i<N; i++) {
            c.toss();
            if (c.getShowingSide() == Side.HEAD) heads++;
        }
        double p = (double) heads / N;
        System.out.println(p);
        if (0.5 - tolerance / 2 < p && p < 0.5 + tolerance / 2) return true;
        return false;
    }

    public static boolean isFair (Coin c) {
        return isFair(c, defaultTolerance);
    }
}
