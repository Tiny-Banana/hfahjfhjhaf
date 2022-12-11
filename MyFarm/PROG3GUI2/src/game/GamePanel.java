package game;

import controller.Controller;
import controller.PlayerController;
import display.Display;
import display.Renderer;
import display.UIPlayer;
import display.UITile;
import event.Event;
import game.state.GameState;
import game.state.State;
import input.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int SCALE = 3;
    public static final int TILE_SIZE = 48; //48 x 48
    public static final int MAX_SCREEN_COL = 17;
    public static final int MAX_SCREEN_ROW = 14;
    public static final int SCREEN_WIDTH = MAX_SCREEN_COL * TILE_SIZE;
    public static final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;
    private final Renderer renderer;
    private UIPlayer uiPlayer;
    private String action;
    private UITile uiTile;

    private KeyHandler keyHandler;
    private Controller controller;
    private State state;

    private boolean running;
    private final double updateRate = 60;

    public GamePanel() {
        keyHandler = new KeyHandler();
        controller = new PlayerController(keyHandler);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.black);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(keyHandler);
        setLayout(null);

        renderer = new Renderer();
        state = new GameState(keyHandler, controller, this);
        uiPlayer = new UIPlayer(state.getPlayer());

        state.getGameObjects().add(state.getPlayer());
        new Display(this);
    }

    @Override
    public void run() {
        running = true;
        double drawInterval = (double) 1000000000 / updateRate;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(running) {
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update() {
        state.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (controller.isRequestingClose()) action = null;

        renderer.render(state, g2, controller, uiPlayer, uiTile, action);

        g2.dispose();
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setUITile(UITile uiTile) {
        this.uiTile = uiTile;
    }
}
