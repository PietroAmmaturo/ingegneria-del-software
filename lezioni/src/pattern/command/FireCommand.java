package pattern.command;

public class FireCommand implements GameCommand {
    public void execute(Game game) {
        game.fire();
    }
}
