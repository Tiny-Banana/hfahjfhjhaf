package display;
import game.GamePanel;

import javax.swing.*;

public class Display extends JFrame {
    public Display(GamePanel gamePanel) {
        setTitle("MyFarm");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        add(gamePanel);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}