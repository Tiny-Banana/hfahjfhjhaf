package controller;

import input.KeyHandler;

import java.awt.event.KeyEvent;

public class PlayerController implements Controller {

    private KeyHandler keyHandler;

    public PlayerController(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }
    @Override
    public boolean isRequestingUp() {
        return keyHandler.isCurrentlyPressed(KeyEvent.VK_W);
    }

    @Override
    public boolean isRequestingDown() {
        return keyHandler.isCurrentlyPressed(KeyEvent.VK_S);
    }

    @Override
    public boolean isRequestingLeft() {
        return keyHandler.isCurrentlyPressed(KeyEvent.VK_A);
    }

    @Override
    public boolean isRequestingRight() {
        return keyHandler.isCurrentlyPressed(KeyEvent.VK_D);
    }

    @Override
    public boolean isRequestingStatus() {
        return keyHandler.isCurrentlyPressed(KeyEvent.VK_U);
    }

    @Override
    public boolean isRequestingClose() {
        return keyHandler.isCurrentlyPressed(KeyEvent.VK_X);
    }

    @Override
    public boolean isRequestingNextDay() {
        return keyHandler.isPressed(KeyEvent.VK_N);
    }
}
