package pattern.abstractfactory;

public class LightApp {
    public Window windowFactory() {
        return new LightWindow();
    }
    public Menu menuFactory() {
        return new LightMenu();
    }
}
