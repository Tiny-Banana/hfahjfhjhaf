package display;

import entity.FarmTile;
import game.GamePanel;

import java.awt.*;

public class UITile extends UI {
    private FarmTile farmTile;

    public UITile(FarmTile farmTile) {
        super();
        this.farmTile = farmTile;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        drawTileView();
    }

    public void drawTileView() {
        final int FRAME_X = GamePanel.TILE_SIZE * 2;
        final int FRAME_Y = GamePanel.TILE_SIZE;
        final int FRAME_WIDTH = GamePanel.TILE_SIZE * 5;
        final int FRAME_HEIGHT = GamePanel.TILE_SIZE * 7;
        drawSubWindow(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);

        //TEXT
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(16F));

        int textX = FRAME_X + 20;
        int textY = FRAME_Y + GamePanel.TILE_SIZE;
        final int lineHeight = 32;

        //NAMES
        g2.drawString("Crop", textX, textY);
        textY += lineHeight;
        g2.drawString("Crop Type", textX, textY);
        textY += lineHeight;
        g2.drawString("Water Count", textX, textY);
        textY += lineHeight;
        g2.drawString("Water Needed", textX, textY);
        textY += lineHeight;
        g2.drawString("Fertilizer Count", textX, textY);
        textY += lineHeight;
        g2.drawString("Fertilizer Needed", textX, textY);
        textY += lineHeight;
        g2.drawString("Days Planted", textX, textY);
        textY += lineHeight;
        g2.drawString("Withered", textX, textY);

        //VALUES
        int tailX = (FRAME_X + FRAME_WIDTH) - 30;
        //RESET textY
        textY =  FRAME_Y + GamePanel.TILE_SIZE;
        String value;

        value = farmTile.getPlantedFarmCrop().getName();
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = farmTile.getPlantedFarmCrop().getCropType();
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(farmTile.getPlantedFarmCrop().getWater());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(farmTile.getPlantedFarmCrop().getWaterNeeded());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(farmTile.getPlantedFarmCrop().getFertilizer());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(farmTile.getPlantedFarmCrop().getFertilizerNeeded());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(farmTile.getPlantedFarmCrop().getDaysPlanted());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(farmTile.getPlantedFarmCrop().getIsWithered());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
    }
}
