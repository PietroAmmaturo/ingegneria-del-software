package pattern.command;

public class RunCommand implements GameCommand {
    public void execute(Game game) {
        game.jump();
    }
}
