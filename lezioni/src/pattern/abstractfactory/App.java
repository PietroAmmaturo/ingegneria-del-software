package pattern.abstractfactory;

public abstract class App {
    // Change visibility if needed
    private Menu menu;
    private Window window;

    public void initApp() {
        menu = menuFactory();
        window = windowFactory();

        // Initializes the menu and the window
    }

    public void useWindow() {
        // Does something with window
    }

    public void useMenu() {
        // Does something with menu
    }

    protected abstract Window windowFactory();
    protected abstract Menu menuFactory();
}
