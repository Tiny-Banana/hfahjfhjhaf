package event;

import display.UITile;
import entity.FarmTile;
import entity.Player;
import entity.crops.*;
import game.GamePanel;
import game.state.State;

public class Event {
    private Player player;
    private FarmTile farmTile;
    private State state;

    public Event(Player player, FarmTile farmTile, State state) {
        this.player = player;
        this.farmTile = farmTile;
        this.state = state;

    }
    public void plow() {
        if (farmTile.isPlowed())
            System.out.println("Plowing not implemented. Tile is already plowed.");
        else {
            farmTile.setPlowed(true);
            player.setExperience(player.getExperience() + .5);
            System.out.println("Plowing implemented.");
        }
    }
    public void water() {
        player.setExperience(player.getExperience() + .5);
        farmTile.getPlantedFarmCrop().setWater(farmTile.getPlantedFarmCrop().getWater() + 1);
        System.out.println("Watering implemented.");
    }

    public void shovel() {
        if (player.getObjectcoins() < 7)
            System.out.println("Shoveling not implemented. You don't have enough Objectcoins.");
        else {
            player.setObjectcoins(player.getObjectcoins() - 7);
            state.getGameObjects().remove(farmTile.getPlantedFarmCrop());
            farmTile.setPlantedFarmCrop(null);
            farmTile.setPlowed(false);
            player.setExperience(player.getExperience() + 2);
            System.out.println("Shoveling implemented.");
        }
    }

    public void pickaxe() {
        if (player.getObjectcoins() < 50)
            System.out.println("Pickaxing not implemented. You don't have enough Objectcoins.");
        else {
            player.setObjectcoins(player.getObjectcoins() - 50);
            farmTile.setIsRock(false);
            player.setExperience(player.getExperience() + 15);
            //remove rock drawing
            System.out.println("Pickaxing implemented.");
        }
    }

    public void harvest() {
//        String name = farmTile.getPlantedFarmCrop().getName();
        player.setExperience(player.getExperience() + farmTile.getPlantedFarmCrop().getExperienceGain());
        //Produce product/s
        int productProduced = (int) (Math.random() * (farmTile.getPlantedFarmCrop().getMaxProduce()) + 1);
        //Computing the Objectcoins earned
        double sellingPrice = 0;
        double harvestTotal = productProduced * (farmTile.getPlantedFarmCrop().getBasePrice() + player.getBonusEarning());
        sellingPrice += harvestTotal * .2 * (Math.min(farmTile.getPlantedFarmCrop().getWater(), farmTile.getPlantedFarmCrop().getWaterLimit() + player.getWaterBonusLimit()) - 1); //Water bonus
        sellingPrice += harvestTotal * .5 * Math.min(farmTile.getPlantedFarmCrop().getFertilizer(), farmTile.getPlantedFarmCrop().getFertilizerLimit() + player.getFertilizerBonusLimit()); //Fertilizer bonus
        sellingPrice += harvestTotal;
        player.setObjectcoins(player.getObjectcoins() + sellingPrice);
        //Resetting tile's status

        //remove crop drawing
        state.getGameObjects().remove(farmTile.getPlantedFarmCrop());
        farmTile.setPlantedFarmCrop(null);
        farmTile.setPlowed(false);

//        System.out.println("Harvesting implemented. You harvested " + productProduced + " " + name + "/s" + ", and earned " + sellingPrice + " Objectcoins by automatic selling of products.");

    }

    public void fertilize() {
        if (player.getObjectcoins() < 10)
            System.out.println("Fertilizing not implemented. You don't have enough Objectcoins.");
        else {
            player.setObjectcoins(player.getObjectcoins() - 10);
            farmTile.getPlantedFarmCrop().setFertilizer(farmTile.getPlantedFarmCrop().getFertilizer() + 1);
            player.setExperience(player.getExperience() + 4);
            System.out.println("Fertilizing implemented.");
        }
    }

    public void view(GamePanel gamePanel) {
        //update game panel and set the action to view
        gamePanel.setAction("view");
        gamePanel.setUITile(new UITile(farmTile));
    }

    public void plant(String cropName) {
        //tile
        FarmCrop plantedCrop = farmTile.getPlantedFarmCrop();
        FarmCrop seed = switch (cropName) {
            case "carrot" -> new Carrot(state, farmTile);
            case "potato" -> new Potato(state, farmTile);
            case "rose" -> new Rose(state, farmTile);
            case "sunflower" -> new Sunflower(state, farmTile);
            case "tulips" -> new Tulips(state, farmTile);
            case "turnip" -> new Turnip(state, farmTile);
            default -> null;
        };

        if (seed == null) {
            System.out.println("Planting not implemented. Seed does not exist.");
        } else if (plantedCrop != null) {
            System.out.println("Planting not implemented. There is already a planted crop.");
        } else if (!farmTile.isPlowed()) {
            System.out.println("Planting not implemented. Tile is unplowed.");
        } else if (player.getObjectcoins() < seed.getSeedCost()) {
            System.out.println("Planting not implemented. You don't have enough Objectcoins.");
        } else {
            //Deduct the seed cost to player's Objectcoins
            player.setObjectcoins(player.getObjectcoins() - (seed.getSeedCost() - player.getSeedCostReduction()));
            farmTile.setPlantedFarmCrop(seed);

            state.getGameObjects().add(seed);
        }
    }
}
