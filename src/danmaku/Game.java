package danmaku;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    static GameEngine danmakuEngine;
    int width;
    int height;

    public static void init(String title,int width,int height,
                            GameEngine engine){
        danmakuEngine = engine;
        JFrame frame = new JFrame(title);
        Game game = new Game();
        frame.add(game);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(width,height);
        frame.setVisible(true);

        while (true){
            engine.updateLogic();
            game.repaint();
        }
    }

    public void gameOver(){
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        danmakuEngine.renderUI(g);
    }
}
