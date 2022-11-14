package pattern.mvc;

import java.util.ArrayList;
import java.util.List;

// User interface of the app
public class MusicAppView {
    private final List<ClickObserver> observerList = new ArrayList<>();
    // The user clicked on the "next" button
    // This should update the music library (move to the next song) and the user interface (update current song)
    public void clickNext() {
        // TODO
        for(ClickObserver clickObserver : observerList) {
            clickObserver.onClick();
        }
    }

    // Display the current song (as a simple example, it prints the title)
    public void updateCurrentSong(Song s) {
        System.out.println(s.getTitle());
    }

    public void addClickObserver(ClickObserver clickObserver){
        observerList.add(clickObserver);
    }
}
