package entity.crops;

import entity.FarmTile;
import game.state.State;

public class Carrot extends FarmCrop {

    public Carrot(State state, FarmTile farmTile) {
        super("Carrot", "Root Crop", 3, 10, 7.5, 0, 1,
                2, 0, 0, 1, false, 0,
                2, 9, state, farmTile);
        this.sprite = state.getGameMap().getTileImage()[3].getSprite();
    }
}
