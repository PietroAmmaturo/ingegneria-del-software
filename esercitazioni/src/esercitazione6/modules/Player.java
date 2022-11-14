package esercitazione6.modules;
import esercitazione6.modules.exceptions.NoFichesException;

public abstract class Player extends GenericPlayer {
    protected int lastCall;

    public Player (String name, int fiches) {
        super(name, fiches);
        lastCall = 0;
    }

    public abstract int call ();

    public void decreaseFiches(int fiches) throws NoFichesException
    {
        if (this.fiches >= fiches) this.fiches -= fiches;
        else throw new NoFichesException("Player "+getName()+" has not enough fiches.");
    }

    public void resetFiches () {this.fiches = 0;}

    public void changeMoney (int money) {
        this.fiches += money;
    }

    public int getLastCall() {
        return lastCall;
    }

    public void setLastCall(int lastCall) {
        this.lastCall = lastCall;
    }
}
