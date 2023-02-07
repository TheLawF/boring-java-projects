package StirngFTG;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FightingGame {
    private JPanel panel1;
    public FightingGame() {
        Player p1 = new Player(150,-20,0);
        Player p2 = new Player(120,20,0);
        textArea1.setText("p1,p2已经就绪");
        textArea1.addKeyListener(new KeyAdapter() {
            boolean kDown = false;
            boolean kUp = false;
            boolean kLeft = false;
            boolean kRight = false;
            boolean kCtrl = false;
            boolean kC = false;
            @Override
            public void keyPressed(KeyEvent e) {
                /* 采用匿名内部类重写键盘事件，格斗游戏一般监听以下按键：
                上箭头：
                 */

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    p1.y -= 3;
                    double distance = Math.pow(Math.pow(p1.x - p2.x,2)
                            + Math.pow(p1.y - p2.y,2),0.5);
                    String s = textArea1.getText();
                    String str = String.format("%.2f",distance);
                    String value = String.valueOf(Double.parseDouble(str));
                    textArea1.setText(s + "\n" + "⬇ " + value);
                    kDown = true;
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    p1.y += 3;
                    double distance = Math.pow(Math.pow(p1.x - p2.x,2)
                            + Math.pow(p1.y - p2.y,2),0.5);
                    String s = textArea1.getText();
                    String str = String.format("%.2f",distance);
                    String value = String.valueOf(Double.parseDouble(str));
                    textArea1.setText(s + "\n" + "⬆ " + value);
                    kUp = true;
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    p1.x -= 2;
                    double distance = Math.pow(Math.pow(p1.x - p2.x,2)
                            + Math.pow(p1.y - p2.y,2),0.5);
                    String s = textArea1.getText();
                    String str = String.format("%.2f",distance);
                    String value = String.valueOf(Double.parseDouble(str));
                    textArea1.setText(s + "\n" + "⬅ " + value);
                    kLeft = true;
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    p1.x += 2;
                    double distance = Math.pow(Math.pow(p1.x - p2.x,2)
                            + Math.pow(p1.y - p2.y,2),0.5);
                    String s = textArea1.getText();
                    String str = String.format("%.2f",distance);
                    String value = String.valueOf(Double.parseDouble(str));
                    textArea1.setText(s + "\n" + "➡ " + value);
                    kRight = true;
                }
                else if (e.getKeyCode() == KeyEvent.VK_X) {
                    double distance = Math.pow(Math.pow(p1.x - p2.x,2)
                                    + Math.pow(p1.y - p2.y,2),0.5);
                    double damage = p1.laser(distance,p2.vertigo);
                    p2.blood -= damage;
                    String s = textArea1.getText();
                    textArea1.setText(s + "\n" + "发动了【光能】--造成伤害" +
                           damage + "；对方血量剩余：" + p2.blood);
                }
                else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    System.out.println("玩家技能：");
                }

                // 从这里开始是【方向键 + 打击键】的组合技能
                if (e.getKeyCode() == KeyEvent.VK_Z && kUp) {
                    // 火箭拳技能
                    double distance = Math.pow(Math.pow(p1.x - p2.x, 2)
                            + Math.pow(p1.y - p2.y, 2), 0.5);
                    String s;
                    s = textArea1.getText();
                    int[] data = p1.rocketHit(distance, p2.vertigo);

                    p2.blood -= data[0];
                    textArea1.setText(s + "\n" + "发动了【火箭拳】--造成伤害" +
                            data[0] + "；对方血量剩余：" + p2.blood);
                    p2.x = data[2];
                }
                else if (e.getKeyCode() == KeyEvent.VK_Z && kDown) {
                    // kick技能的释放，需要传入距离和对手的眩晕值
                    double distance = Math.pow(Math.pow(p1.x - p2.x, 2)
                            + Math.pow(p1.y - p2.y, 2), 0.5);
                    String s;
                    s = textArea1.getText();
                    int[] data = p1.kick(distance, p2.vertigo);

                    p2.blood -= data[0];
                    textArea1.setText(s + "\n" + "发动了【Kick】--造成伤害" +
                            data[0] + "；对方血量剩余：" + p2.blood);
                    p2.x += data[2];
                }
                else if (e.getKeyCode() == KeyEvent.VK_Z && kRight) {
                    double distance = Math.pow(Math.pow(p1.x - p2.x, 2)
                            + Math.pow(p1.y - p2.y, 2), 0.5);
                    String s;
                    s = textArea1.getText();
                    int[] data = p1.criticalHit(distance, p2.vertigo);

                    p2.blood -= data[0];
                    textArea1.setText(s + "\n" + "发动了【会心一击】--造成伤害" +
                            data[0] + "；对方血量剩余：" + p2.blood);
                    p2.x += data[2];
                }
                else if (e.getKeyCode() == KeyEvent.VK_Z) {
                    double distance = Math.pow(Math.pow(p1.x - p2.x,2)
                            + Math.pow(p1.y - p2.y,2),0.5);
                    String s = textArea1.getText();
                    int[] data = p1.fist(distance, p2.vertigo);
                    p2.blood -= data[0];
                    textArea1.setText(s + "\n" + "发动了【重拳出击】--造成伤害" +
                            data[0] + "；对方血量剩余：" + p2.blood);
                }

                if (e.getKeyCode() == KeyEvent.VK_C) {
                    kC = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    kDown = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    kUp = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    kLeft = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    kRight = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    kCtrl = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    kC = false;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FightingGame");
        frame.setContentPane(new FightingGame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        }

    private JTextArea textArea1;
    private JScrollPane pane;
}
