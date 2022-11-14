package esercitazione6.modules;

import java.util.Hashtable;

class NumericValue {
    private final static Hashtable<CardValue, int[]> dict = new Hashtable<>();

    static {
        dict.put(CardValue.ONE, new int[]{1, 11});
        dict.put(CardValue.TWO, new int[]{2});
        dict.put(CardValue.THREE, new int[]{3});
        dict.put(CardValue.FOUR, new int[]{4});
        dict.put(CardValue.FIVE, new int[]{5});
        dict.put(CardValue.SIX, new int[]{6});
        dict.put(CardValue.SEVEN, new int[]{7});
        dict.put(CardValue.EIGHT, new int[]{8});
        dict.put(CardValue.NINE, new int[]{9});
        dict.put(CardValue.TEN, new int[]{10});
        dict.put(CardValue.J, new int[]{10});
        dict.put(CardValue.Q, new int[]{10});
        dict.put(CardValue.K, new int[]{10});
    }

    public static int[] getValue(CardValue v) {
        return dict.get(v);
    }
}

public class Card {
    private final CardValue value;
    private final int[] numericValues;
    private final Suit suit;

    public Card (CardValue value, Suit suit) {
        this.value = value;
        this.numericValues = NumericValue.getValue(value);
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public int[] getNumericValues() {
        return numericValues;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return this.value + " " + this.suit;
    }
}
