package RailLines;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TransitNetwork {
    public TransitNetwork(ArrayList<ArrayList<Point>> lines) {
        JFrame frame = new JFrame("幻想乡轨道交通线网图_2022.9.5_version");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(800, 600);
        frame.setVisible(true);

        JButton addLines = new JButton("添加线路");
        JPanel panel = new JPanel();
        addLines.setFont(new Font("宋体",Font.BOLD,50));
        Box box = Box.createVerticalBox();
        frame.repaint();
        ArrayList<Point> stations = new ArrayList<>();

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        System.out.println(red+","+green+","+blue);
        Line line = new Line(lines,
                new Color(red,green,blue));
        line.updateUI();
        box.add(line);
        frame.repaint();
        box.repaint();
        frame.repaint();
    }


}
