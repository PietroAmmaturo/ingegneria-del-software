package esercitazione6.modules;

import esercitazione6.modules.utils.PointsUtils;

import java.util.List;

public class DummyPlayer extends Player{
    public DummyPlayer(String name, int fiches) {
        super(name, fiches);
    }

    @Override
    public boolean drawCard(List<List<Card>> cards) {
        if (PointsUtils.getPoints(this.cards)<17) return true;
        return false;
    }

    @Override
    public int call() {
        return 1;
    }
}
