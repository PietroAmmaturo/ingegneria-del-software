package pattern.observer;

public class Main {
    public static void Main() {
        LogClickObserver observer = new LogClickObserver();
        UserInterface userInterface = new UserInterface();
        userInterface.addClickObserver(observer);
    }
}
