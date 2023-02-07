import javax.swing.*;
import java.awt.*;

public class DanmakuWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("danmaku");
        JPanel jp = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080,640);
        frame.setVisible(true);

        JLabel[] label = new JLabel[2];
        JLabel enerymy = new JLabel();
        JLabel bullet = new JLabel();
        enerymy.setIcon(new ImageIcon("E:\\anything\\pix_image\\center.png"));
        bullet.setIcon(new ImageIcon("E:\\anything\\pix_image\\bullet.png"));

        Dimension d = label[1].getPreferredSize();

        label[0] = enerymy;
        label[1] = bullet;
        label[1].setBounds(100,100,d.width,d.height);

        Container c = frame.getContentPane();
        Danmaku danmaku = new Danmaku();
        c.add(label[0]);
        jp.add(label[1]);
        frame.add(jp);
        frame.repaint();

    }
}
