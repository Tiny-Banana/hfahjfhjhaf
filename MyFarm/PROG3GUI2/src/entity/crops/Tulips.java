package entity.crops;

import entity.FarmTile;
import game.state.State;

public class Tulips extends FarmCrop{
    public Tulips(State state, FarmTile farmTile) {
        super("Tulips", "Flower", 2, 10, 5, 0, 2,
                3, 0, 0, 1, false, 0,
                1, 9, state, farmTile);
    }
}
