package esercitazione6.modules;

import esercitazione6.modules.utils.PointsUtils;

import java.util.List;

public class Dealer extends GenericPlayer {

    public Dealer () {
        super("Dealer", 0);
    }

    public boolean drawCard (List<List<Card>> c) {
        if (PointsUtils.getPoints(cards) < 17) return true;
        return false;
    }

    public void loose (int fiches) {
        this.fiches -= fiches;
    }
}
