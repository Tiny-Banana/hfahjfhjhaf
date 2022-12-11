package input;

import entity.FarmTile;
import entity.Player;
import event.Event;
import game.GamePanel;
import game.state.State;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    private Event event;
    private GamePanel gamePanel;

    public ActionHandler(Player player, FarmTile farmTile, State state, GamePanel gamePanel) {
        this.event = new Event(player, farmTile, state);
        this.gamePanel = gamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();

        switch (choice) {
            case "plow" -> event.plow();
            case "turnip", "carrot", "rose", "potato", "tulips" -> event.plant(choice);
            case "water" -> event.water();
            case "shovel" -> event.shovel();
            case "pickaxe" -> event.pickaxe();
            case "fertilize" -> event.fertilize();
            case "harvest" -> event.harvest();
            case "view" -> event.view(gamePanel);
        }
    }
}
