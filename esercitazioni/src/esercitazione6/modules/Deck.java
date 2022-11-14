package esercitazione6.modules;

import esercitazione6.modules.exceptions.NoCardsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    private Random generator;

    public Deck () {
        this.generator = new Random();
        initializeDeck();
    }

    public Card initializeDeckAndDraw () {
        this.initializeDeck();
        int idx = generator.nextInt(cards.size());
        Card c = cards.get(idx);
        cards.remove(idx);
        return c;
    }

    public void initializeDeck() {
        cards = new ArrayList<>();
        for (CardValue v : CardValue.values()) {
            for (Suit s : Suit.values()) {
                cards.add(new Card(v, s));
            }
        }
    }


    public Card drawCard () throws NoCardsException {
        if (cards.size() > 0)  {
            int idx = generator.nextInt(cards.size());
            Card c = cards.get(idx);
            cards.remove(idx);
            return c;
        } else throw new NoCardsException("No cards remaining in the deck");
    }

}
