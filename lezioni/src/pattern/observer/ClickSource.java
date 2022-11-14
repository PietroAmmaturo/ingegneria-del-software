package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ClickSource {
    private final List<ClickObserver> clickObservers = new ArrayList<>();
    // aggiungi observer
    public void addClickObserver(ClickObserver clickObserver) {
        clickObservers.add(clickObserver);
    }

    // notifica observers
    public void notifyClickObservers() {
        for (ClickObserver clickObserver: clickObservers) {
            clickObserver.onClick();
        }
    }
}
