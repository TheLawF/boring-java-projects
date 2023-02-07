import javax.swing.*;
import java.awt.*;

public class Danmaku {
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("danmaku");
        JPanel jp = new JPanel();

        frame.setContentPane(new Danmaku().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080,640);
        frame.setVisible(true);

        Container c = frame.getContentPane();
        Danmaku danmaku = new Danmaku();
        JLabel[] label = danmaku.createUIComponents(frame);
        c.add(label[0]);
        jp.add(label[1]);
        frame.add(jp);
        frame.repaint();

    }

    private JLabel[] createUIComponents(Component component) {
        // TODO: place custom component creation code here
        JLabel[] labelArr = new JLabel[2];
        JLabel enerymy = new JLabel();
        JLabel bullet = new JLabel();
        enerymy.setIcon(new ImageIcon("E:\\anything\\pix_image\\center.png"));
        bullet.setIcon(new ImageIcon("E:\\anything\\pix_image\\bullet.png"));

        labelArr[0] = enerymy;
        labelArr[1] = bullet;
        labelArr[1].setLocation(100,100);
        return labelArr;
    }

    public void danmakuType1(){

    }
}
