import game.GamePanel;

public class Launcher {

    public static void main(String[] args) {
       new Thread(new GamePanel()).start();
    }
}
