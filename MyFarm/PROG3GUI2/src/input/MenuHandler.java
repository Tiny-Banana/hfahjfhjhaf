package input;

import entity.FarmTile;
import entity.Player;
import game.GamePanel;
import game.state.State;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuHandler implements MenuListener {

    private JMenu baseMenu;
    private FarmTile farmTile;
    private Player player;
    private State state;
    private GamePanel gamePanel;

    public MenuHandler(JMenu baseMenu, FarmTile farmTile, Player player, State state, GamePanel gamePanel) {
        this.baseMenu = baseMenu;
        this.farmTile = farmTile;
        this.player = player;
        this.state = state;
        this.gamePanel = gamePanel;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        JMenuItem menus[] = new JMenuItem[6];

        menus[0] = new JMenuItem("Turnip");
        menus[0].addActionListener(new ActionHandler(player, farmTile, state, gamePanel));
        menus[0].setActionCommand("turnip");
        baseMenu.add(menus[0]);

        menus[1] = new JMenuItem("Carrot");
        menus[1].addActionListener(new ActionHandler(player, farmTile, state, gamePanel));
        menus[1].setActionCommand("carrot");
        baseMenu.add(menus[1]);

        menus[2] = new JMenuItem("Rose");
        menus[2].addActionListener(new ActionHandler(player, farmTile, state, gamePanel));
        menus[2].setActionCommand("rose");
        baseMenu.add(menus[2]);

        menus[3] = new JMenuItem("Potato");
        menus[3].addActionListener(new ActionHandler(player, farmTile, state, gamePanel));
        menus[3].setActionCommand("potato");
        baseMenu.add(menus[3]);

        menus[4] = new JMenuItem("Sunflower");
        menus[4].addActionListener(new ActionHandler(player, farmTile, state, gamePanel));
        menus[4].setActionCommand("sunflower");
        baseMenu.add(menus[4]);

        menus[5] = new JMenuItem("Tulips");
        menus[5].addActionListener(new ActionHandler(player, farmTile, state, gamePanel));
        menus[5].setActionCommand("tulips");
        baseMenu.add( menus[5]);
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        baseMenu.removeAll();
    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
