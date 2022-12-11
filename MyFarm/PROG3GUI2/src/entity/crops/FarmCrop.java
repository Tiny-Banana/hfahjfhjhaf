package entity.crops;

import entity.FarmTile;
import entity.GameObject;
import game.state.State;

import java.awt.*;

public abstract class FarmCrop extends GameObject {

    protected String name;
    protected Image sprite;
    protected String cropType;
    protected int harvestTime;
    protected int seedCost;
    protected double experienceGain;
    protected int water;
    protected int waterNeeded;
    protected int waterLimit;
    protected int fertilizer;
    protected int fertilizerNeeded;
    protected int fertilizerLimit;
    protected boolean isWithered;
    protected int daysPlanted;
    protected int maxProduce;
    protected int basePrice;
    public FarmCrop(String name, String cropType, int harvestTime, int seedCost, double experienceGain, int water,
                    int waterNeeded, int waterLimit, int fertilizer, int fertilizerNeeded, int fertilizerLimit,
                    boolean isWithered, int daysPlanted, int maxProduce, int basePrice, State state, FarmTile farmTile) {
        this.sprite = state.getGameMap().getTileImage()[3].getSprite();
        setPosition(farmTile.getPosition());
        this.name = name;
        this.objectName = "plant";
        this.cropType = cropType;
        this.harvestTime = harvestTime;
        this.seedCost = seedCost;
        this.experienceGain = experienceGain;
        this.water = water;
        this.waterNeeded = waterNeeded;
        this.waterLimit = waterLimit;
        this.fertilizer = fertilizer;
        this.fertilizerNeeded = fertilizerNeeded;
        this.fertilizerLimit = fertilizerLimit;
        this.isWithered = isWithered;
        this.daysPlanted = daysPlanted;
        this.maxProduce = maxProduce;
        this.basePrice = basePrice;
    }
    @Override
    public void update() {

    }

    @Override
    public Image getSprite() {
        return sprite;
    }

    //Getters and Setters
    public String getCropType() {
        return cropType;
    }

    public double getHarvestTime() {
        return harvestTime;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public double getExperienceGain() {
        return experienceGain;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(int fertilizer) {
        this.fertilizer = fertilizer;
    }

    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }

    public boolean getIsWithered() {
        return isWithered;
    }

    public void setIsWithered(boolean isWithered) {
        this.isWithered = isWithered;
    }

    public int getDaysPlanted() {
        return daysPlanted;
    }

    public void setDaysPlanted(int daysPlanted) {
        this.daysPlanted = daysPlanted;
    }

    public int getWaterLimit() {
        return waterLimit;
    }

    public int getFertilizerLimit() {
        return fertilizerLimit;
    }

    public int getMaxProduce() {
        return maxProduce;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

}

