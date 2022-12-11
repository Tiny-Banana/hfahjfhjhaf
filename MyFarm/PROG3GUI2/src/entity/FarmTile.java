package entity;

import core.Position;
import entity.crops.FarmCrop;
import game.GamePanel;
import game.state.State;
import input.ActionHandler;
import input.MenuHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FarmTile extends GameObject {

    private Player player;
    private Image sprite;
    private FarmCrop plantedFarmCrop;
    private boolean isPlowed;
    private boolean rock;
    private JLabel objectLabel;
    private JPopupMenu popupMenu;
    private JMenuItem[] menu;
    private State state;
    private GamePanel gamePanel;
    //crop

    //player, and controller
    public FarmTile(State state, int x, int y, GamePanel gamePanel) {
        this.plantedFarmCrop = null;
        this.isPlowed  = false;
        this.rock = false;

        this.sprite = state.getGameMap().getTileImage()[1].getSprite();
        this.player = state.getPlayer();
        this.setPosition(new Position(x, y));
        this.objectName = "tile";
        this.objectLabel = new JLabel();
        this.objectLabel.setBounds(x, y, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);

        this.state = state;
        this.gamePanel = gamePanel;
        state.getGameObjects().add(this);
    }

    public JLabel getObjectLabel() {
        return objectLabel;
    }

    private void addMenuItems() {
        menu = new JMenuItem[8];
        menu[0] = new JMenuItem("View");
        menu[0].addActionListener(new ActionHandler(player, this, state, gamePanel));
        menu[0].setActionCommand("view");

        menu[1] = new JMenuItem("Plow");
        menu[1].addActionListener(new ActionHandler(player, this, state, gamePanel));
        menu[1].setActionCommand("plow");

        menu[2] = new JMenuItem("Water");
        menu[2].addActionListener(new ActionHandler(player, this, state, gamePanel));
        menu[2].setActionCommand("water");

        menu[3] = new JMenuItem("Fertilize");
        menu[3].addActionListener(new ActionHandler(player, this, state, gamePanel));
        menu[3].setActionCommand("fertilize");

        menu[4] = new JMenuItem("Shovel");
        menu[4].addActionListener(new ActionHandler(player, this, state, gamePanel));
        menu[4].setActionCommand("shovel");

        menu[5] = new JMenuItem("Harvest");
        menu[5].addActionListener(new ActionHandler(player, this, state, gamePanel));
        menu[5].setActionCommand("harvest");

        menu[6] = new JMenuItem("Pickaxe");
        menu[6].addActionListener(new ActionHandler(player, this, state, gamePanel));
        menu[6].setActionCommand("pickaxe");

        JMenu menus = new JMenu("Plant");
        menus.addMenuListener(new MenuHandler(menus, this, player, state, gamePanel));

        popupMenu.add(menu[1]);
        popupMenu.add(menus);

        if (plantedFarmCrop != null) {
            popupMenu.add(menu[0]);
            popupMenu.add(menu[2]);
            popupMenu.add(menu[3]);
            popupMenu.remove(menu[1]);
            popupMenu.remove(menus);
            if (plantedFarmCrop.getIsWithered()) {
                popupMenu.add(menu[4]);
            }
            if (plantedFarmCrop.getDaysPlanted() == plantedFarmCrop.getHarvestTime() &&
                    plantedFarmCrop.getWater() >= plantedFarmCrop.getWaterNeeded() &&
                    plantedFarmCrop.getFertilizer() >= plantedFarmCrop.getFertilizerNeeded()) {
                popupMenu.add(menu[5]);
            }
        }
    }

    private void displayPopUp() {
        this.popupMenu = new JPopupMenu();
        this.menu = new JMenu[3];
        addMenuItems();
        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(objectLabel, e.getX(), e.getY());
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }


    @Override
    public void update() {
    }

    /**
     * Advance the days in the game and update if the crop has withered or not
     */
    public void advanceDays() {
        if (plantedFarmCrop != null) {
            plantedFarmCrop.setDaysPlanted(plantedFarmCrop.getDaysPlanted() + 1);
            if (plantedFarmCrop.getDaysPlanted() > plantedFarmCrop.getHarvestTime() && !plantedFarmCrop.getIsWithered()) {
                plantedFarmCrop.setIsWithered(true);
                System.out.println("\nYour crop has now withered.");
            }
        }
    }

    public void callPopUp() {
        displayPopUp();
    }

    @Override
    public Image getSprite() {
        return sprite;
    }

    public void setRock(boolean rock) {
        this.rock = rock;
    }

    public FarmCrop getPlantedFarmCrop() {
        return plantedFarmCrop;
    }

    public void setPlantedFarmCrop(FarmCrop plantedFarmCrop) {
        this.plantedFarmCrop = plantedFarmCrop;
    }

    public boolean isPlowed() {
        return isPlowed;
    }

    public void setPlowed(boolean plowed) {
        isPlowed = plowed;
    }

    public boolean isRock() {
        return rock;
    }

    public void setIsRock(boolean isRock) {
        this.rock = isRock;
    }
}
