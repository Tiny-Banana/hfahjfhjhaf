package game.state;

import controller.Controller;
import entity.GameObject;
import entity.Player;
import farm.FarmBoard;
import game.GamePanel;
import gfx.SpriteLibrary;
import input.KeyHandler;
import map.GameMap;

import java.util.ArrayList;
import java.util.List;

public abstract class State {
    protected GameMap gameMap;
    protected List<GameObject> gameObjects;
    protected SpriteLibrary spriteLibrary;
    protected KeyHandler keyHandler;
    protected Player player;
    protected FarmBoard farmBoard;
    protected GamePanel gamePanel;
    protected Controller controller;

    public State(KeyHandler keyHandler, Controller controller) {
        this.keyHandler = keyHandler;
        this.gameObjects = new ArrayList<>();
        this.spriteLibrary = new SpriteLibrary();
        this.player = new Player(controller, spriteLibrary);
        this.controller = controller;
    }

    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
        if (controller.isRequestingNextDay()) {
            farmBoard.advanceDaysPlanted();
            player.setDaysPlaying(player.getDaysPlaying() + 1);
        }
        farmBoard.updateTilePopUp();
        player.updateLevel();
    }


    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
    public GameMap getGameMap() {
        return gameMap;
    }
    public KeyHandler getKeyHandler() {
        return keyHandler;
    }
    public Player getPlayer() {
        return player;
    }
    public FarmBoard getFarmBoard() {
        return farmBoard;
    }
    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
