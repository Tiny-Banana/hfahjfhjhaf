package display;

import controller.Controller;
import game.GamePanel;
import game.state.State;

import java.awt.*;

public class Renderer {

    public void render(State state, Graphics2D graphics, Controller controller, UIPlayer uiPlayer,
                       UITile uiTile, String action) {
        renderMap(state, graphics);
        renderObject(state, graphics);
        if (controller.isRequestingStatus()) uiPlayer.draw(graphics);
        if (action != null) uiTile.draw(graphics);
    }

    private void renderObject(State state, Graphics2D graphics) {
        for (int i = 0; i < state.getGameObjects().size(); i++) {
            if (state.getGameObjects().get(i).getObjectName().equals("player")){
                graphics.drawImage(
                        state.getGameObjects().get(i).getSprite(),
                        state.getGameObjects().get(i).getPosition().intX(),
                        state.getGameObjects().get(i).getPosition().intY(),
                        GamePanel.TILE_SIZE * 3,
                        GamePanel.TILE_SIZE * 3,
                        null
                );
            } else {
                graphics.drawImage(
                        state.getGameObjects().get(i).getSprite(),
                        state.getGameObjects().get(i).getPosition().intX(),
                        state.getGameObjects().get(i).getPosition().intY(),
                        GamePanel.TILE_SIZE,
                        GamePanel.TILE_SIZE,
                        null
                );
            }
        }
    }
    private void renderMap(State state, Graphics graphics) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < GamePanel.MAX_SCREEN_COL && row < GamePanel.MAX_SCREEN_ROW) {
            int tileNum = state.getGameMap().getTileMap()[row][col];

            graphics.drawImage(
                    state.getGameMap().getTileImage()[tileNum].getSprite(),
                    x, y,
                    GamePanel.TILE_SIZE,
                    GamePanel.TILE_SIZE,
                    null
            );
            col++;
            x += GamePanel.TILE_SIZE;

            if (col == GamePanel.MAX_SCREEN_COL) {
                col = 0;
                x = 0;
                row++;
                y += GamePanel.TILE_SIZE;
            }
        }
    }
}
