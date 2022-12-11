package display;

import entity.Player;
import game.GamePanel;

import java.awt.*;

public class UIPlayer extends UI{
    Player player;

    public UIPlayer(Player player) {
        super();
        this.player = player;
    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        drawCharacterScreen();
    }

    public void drawCharacterScreen() {
        //CREATE A FRAME
        final int FRAME_X = GamePanel.TILE_SIZE * 2;
        final int FRAME_Y = GamePanel.TILE_SIZE;
        final int FRAME_WIDTH = GamePanel.TILE_SIZE * 5;
        final int FRAME_HEIGHT = GamePanel.TILE_SIZE * 5;
        drawSubWindow(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);

        //TEXT
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(16F));

        int textX = FRAME_X + 20;
        int textY = FRAME_Y + GamePanel.TILE_SIZE;
        final int lineHeight = 32;

        //NAMES
        g2.drawString("Farmer Type", textX, textY);
        textY += lineHeight;
        g2.drawString("Experience", textX, textY);
        textY += lineHeight;
        g2.drawString("Level", textX, textY);
        textY += lineHeight;
        g2.drawString("Days Playing", textX, textY);
        textY += lineHeight;
        g2.drawString("ObjectCoins", textX, textY);

        //VALUES
        int tailX = (FRAME_X + FRAME_WIDTH) - 30;
        //RESET textY
        textY =  FRAME_Y + GamePanel.TILE_SIZE;
        String value;

        value = player.getFarmerType();
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getExperience());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getLevel());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getDaysPlaying());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getObjectcoins());
        textX = getXforAlign(value, tailX);
        g2.drawString(value, textX, textY);
    }
}
