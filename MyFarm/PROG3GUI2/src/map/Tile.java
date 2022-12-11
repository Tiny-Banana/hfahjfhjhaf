package map;

import gfx.SpriteLibrary;

import java.awt.*;

public class Tile {

    private Image sprite;

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(SpriteLibrary spriteLibrary, String fileName) {
        this.sprite = spriteLibrary.getTile(fileName);
    }
}
