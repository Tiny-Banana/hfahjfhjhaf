package game.state;

import controller.Controller;
import farm.FarmBoard;
import game.GamePanel;
import input.KeyHandler;
import map.GameMap;

//real time update of the game
public class GameState extends State {

    //defeat conditions
    private boolean playing;

    public GameState(KeyHandler keyHandler, Controller controller, GamePanel gamePanel) {
        super(keyHandler, controller);
        this.playing = true;
        this.gameMap = new GameMap(spriteLibrary);
        this.farmBoard = new FarmBoard(this, gamePanel);
        this.gamePanel = gamePanel;
    }
    //playing conditions dito ilalagay
}
