package danmaku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DanmakuMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("弹幕测试");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize((int) (screen.getWidth()-300),
                (int) (screen.getHeight()-300));
        frame.setVisible(true);

        int width = frame.getWidth();
        int height = frame.getHeight();
        /*
        GamePanel panel = new GamePanel(width,y);
        frame.add(panel);

         */
        frame.repaint();

        JPanel jp = new JPanel();
        JButton button1 = new JButton("弹幕样式一");
        JButton button2 = new JButton("弹幕样式二");
        JButton button3 = new JButton("弹幕样式三");
        Font font1 = new Font("黑体",Font.BOLD,40);

        button1.setFont(font1);
        button2.setFont(font1);
        button3.setFont(font1);

        button1.addActionListener(e -> {
            //panel.removeAll();

        });

        jp.add(button1,BorderLayout.SOUTH);
        jp.add(button2,BorderLayout.SOUTH);
        jp.add(button3,BorderLayout.SOUTH);
        frame.add(jp,BorderLayout.SOUTH);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    //panel.width--;
                }
                if (e.getKeyChar() == KeyEvent.VK_DOWN) {
                    //panel.y++;
                }

            }
        });
        frame.repaint();

        while (true){
            System.out.print("");
            if (button1.getModel().isPressed()) {
                jp.removeAll();
                jp.updateUI();
                frame.repaint();
                break;
            }
        }

        /*
        DanmakuType type1 = new DanmakuType(width,y,2);
        System.out.println(type1.index);
        frame.add(type1);
        type1.updateUI();
        frame.repaint();
         */
        Game.init("弹幕界面",1080,640,new DanmakuEngine());
    }
}
