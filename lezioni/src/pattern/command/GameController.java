package pattern.command;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Game game;
    private final List<GameControllerButton> controllerButtons;

    GameController(int numButtons, Game game) {
        this.game = game;
        this.controllerButtons = new ArrayList<>(numButtons);
        for (int i = 0; i < numButtons; i++) {
            controllerButtons.add(new GameControllerButton());
        }
    }

    public void changeGame(Game game) {
        this.game = game;
        for (GameControllerButton button : controllerButtons) {
            button.setGame(game);
        }
    }

    public void setButtonAction(int buttonId, GameCommand command) {
        controllerButtons.get(buttonId).setCommand(command);
    }

}
