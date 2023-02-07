package danmaku;

import java.awt.*;
import java.util.Scanner;

public abstract class GameEngine {

    public abstract void updateLogic();

    public abstract void renderUI(Graphics g);

    public String getUserInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
