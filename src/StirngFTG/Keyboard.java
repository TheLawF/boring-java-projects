package StirngFTG;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("kill!");
        }
    }
}
