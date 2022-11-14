package pattern.abstractfactory;

public class DarkApp {
    public Window windowFactory() {
        return new DarkWindow();
    }
    public Menu menuFactory() {
        return new DarkMenu();
    }
}
