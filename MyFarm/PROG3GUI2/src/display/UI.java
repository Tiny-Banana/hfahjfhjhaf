package display;

import java.awt.*;

public class UI {
    Graphics2D g2;
    Font arial_40, arial_80B;

    public UI() {
        arial_40 = new Font("Arial", Font.PLAIN, 30);
        arial_80B  = new Font("Arial", Font.BOLD, 20);
    }

    public void showMessage(String text) {
//        message = text;
//        messageOn = true;
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color color = new Color(0, 0, 0, 210);
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        color = new Color(255, 255, 255);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXforAlign(String text, int tailX) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return tailX - length;
    }
}

