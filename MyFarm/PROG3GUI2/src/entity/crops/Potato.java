package entity.crops;

import entity.FarmTile;
import game.state.State;

public class Potato extends FarmCrop{
    public Potato(State state, FarmTile farmTile) {
        super("Potato", "Root Crop", 5, 20, 12.5, 0, 3,
                4, 0, 1, 2, false, 0,
                10,  3, state, farmTile);
    }
}
