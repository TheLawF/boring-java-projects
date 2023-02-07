package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DrawMain {


    public static void main(String[] args) {

        JFrame frame = new JFrame("Smooth Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(800, 600);
        frame.setVisible(true);

        HashMap<Point, Point> pointMap = new HashMap<>();
        DrawPanel dp = new DrawPanel();
        frame.add(dp);

        frame.addMouseListener(new MouseAdapter() {
            int startX = 0;
            int startY;
            int endX;
            int endY;
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    startX = e.getX();
                    startY = e.getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                pointMap.put(new Point(startX,startY), new Point(endX, endY));
                dp.getGraphics().drawLine(startX, startY, endX, endY);
                // dp.updateUI();
                // frame.repaint();
            }
        });
        String linePoints;

        frame.repaint();
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String string = StringHelper.toString(pointMap);
            System.out.println(string);

        }

    }

}
