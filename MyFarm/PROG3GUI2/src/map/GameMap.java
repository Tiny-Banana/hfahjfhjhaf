package map;

import game.GamePanel;
import gfx.SpriteLibrary;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GameMap {

    private Tile[] tileImage;
    private int[][] tileMap;

    public GameMap(SpriteLibrary spriteLibrary) {
        tileImage = new Tile[4];
        tileMap = new int[GamePanel.MAX_SCREEN_ROW][GamePanel.MAX_SCREEN_COL];
        readTiles();
        initializeTileImages(spriteLibrary);
    }

    private void readTiles() {
        try {
            InputStream is = getClass().getResourceAsStream(("/maps/map1.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < GamePanel.MAX_SCREEN_COL && row < GamePanel.MAX_SCREEN_ROW) {
                String line = br.readLine();
                String[] numbers = line.split(" ");

                while (col < GamePanel.MAX_SCREEN_COL) {
                    int num = Integer.parseInt(numbers[col]);
                    tileMap[row][col] = num;
                    col++;
                }

                if (col == GamePanel.MAX_SCREEN_COL) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {

        }
    }

    public void initializeTileImages(SpriteLibrary spriteLibrary) {
        for (int i = 0; i < tileImage.length; i++) {
            tileImage[i] = new Tile();
        }
        tileImage[0].setSprite(spriteLibrary, "grass");
        tileImage[1].setSprite(spriteLibrary, "dirt");
        tileImage[2].setSprite(spriteLibrary, "water");
        tileImage[3].setSprite(spriteLibrary, "plant");
    }

    public Tile[] getTileImage() {
        return tileImage;
    }

    public int[][] getTileMap() {
        return tileMap;
    }
}