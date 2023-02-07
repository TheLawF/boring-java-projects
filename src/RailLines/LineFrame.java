package RailLines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class LineFrame extends JFrame {

    int x2;
    int y2;

    public static void main(String[] args) {
        int x1 = 0;
        int y1 = 0;
        ArrayList<Point> stations = new ArrayList<>();
        ArrayList<ArrayList<Point>> lines = new ArrayList<>();

        JFrame frame = new JFrame("幻想乡轨道交通线网设置");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(800, 600);
        frame.setVisible(true);

        JTextField number = new JTextField();
        JTextField p1X = new JTextField();
        JTextField p1Y = new JTextField();
        Dimension dimension = new Dimension(60,40);
        Dimension d1 = new Dimension(100,40);

        number.setPreferredSize(dimension);
        p1X.setPreferredSize(d1);
        p1Y.setPreferredSize(d1);
        JTextArea area = new JTextArea();
        JPanel panel1 = new JPanel();
        Box box = Box.createVerticalBox();
        LineSurface surface = new LineSurface();

        JButton submit = new JButton("提交新站点");
        JButton confirm = new JButton("确认创建");
        JButton addLines = new JButton("添加线路");
        submit.setFont(new Font("宋体",Font.BOLD,50));
        confirm.setFont(new Font("宋体",Font.BOLD,50));

        Point point = new Point(x1, y1);


        submit.addActionListener(e -> {
            p1X.setText(null);
            p1Y.setText(null);
        });

        addLines.addActionListener(e -> {});

        panel1.add(number);
        panel1.add(p1X);
        panel1.add(p1Y);

        box.add(panel1);
        box.add(surface);
        box.add(submit);
        box.add(confirm);
        frame.add(box);

        if (number.getText().matches("^-?\\d+$")) {
            ArrayList<Integer> indexes = new ArrayList<>();
            int index = Integer.parseInt(number.getText());
            indexes.add(index);
            for (int i = 0;i < indexes.size();i++) {
                if (i < indexes.size()-1) {
                    if (!Objects.equals(indexes.get(i), indexes.get(i + 1))) {
                        ArrayList<Point> points = new ArrayList<>();
                        points.add(point);
                        lines.add(points);
                    }
                }
            }
        }

        if (p1X.getText().matches("^-?\\d+$")) {
            x1 = Integer.parseInt(p1X.getText());
        }
        if (p1Y.getText().matches("^-?\\d+$")) {
            y1 = Integer.parseInt(p1Y.getText());
        }
        stations.add(point);
        lines.add(stations);

        confirm.addActionListener(e -> {
            new TransitNetwork(lines);
        });

    }

}
