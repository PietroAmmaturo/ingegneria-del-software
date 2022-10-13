package generics;

import java.util.Iterator;

public class Pair<T> implements Iterable<T> {
    private final T first;
    private final T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public Iterator<T> iterator() {
        return new PairIterator<>(first, second);
    }
}

class PairIterator<T> implements Iterator<T> {
    private final T first;
    private final T second;
    private int index;

    public PairIterator(T first, T second) {
        this.first = first;
        this.second = second;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < 2;
    }

    public T next() {
        if (index == 0) {
            index++;
            return first;
        } else if (index == 1) {
            index++;
            return second;
        }
        return null;
    }
}
