package pattern.mvc;

public class MusicAppController implements ClickObserver{
    MusicLibraryModel model;
    MusicAppView view;

    public MusicAppController(MusicLibraryModel model) {
        this.model = model;
        this.view = view;
    }

    public void onClick() {
        Song newSong = model.getNextSong();
        view.updateCurrentSong(newSong);
    }
}
