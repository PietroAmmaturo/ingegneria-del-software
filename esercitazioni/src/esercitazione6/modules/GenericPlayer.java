package esercitazione6.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class GenericPlayer {
    protected int fiches;
    protected List<Card> cards;
    protected final String name;

    public GenericPlayer(String name, int fiches) {
        this.fiches = fiches;
        cards = new ArrayList<>();
        this.name = name;
    }

    public void win (int fiches) {
        this.fiches += fiches;
    }

    public int getFiches() {
        return fiches;
    }

    public void resetCards () {
        this.cards = new ArrayList<>();
    }

    public void addCard (Card c) {
        cards.add(c);
    }

    public List<Card> getCards() {
        return cards;
    }

    public abstract boolean drawCard (List<List<Card>> c);

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericPlayer)) return false;
        GenericPlayer that = (GenericPlayer) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
