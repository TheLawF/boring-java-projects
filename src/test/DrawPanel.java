package test;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class DrawPanel extends JPanel {

    Color color = Color.RED;
    ArrayList<Point> points;
    public static final int SIZE = 8;


    public Point2D cubicBezier(double t, ArrayList<Point> p)
    {
        Point2D[] temp = new Point2D[p.size()];
        for(int k=0; k < p.size(); k++)
            temp[k]=p.get(k);
        for(int i=0; i< 3; i++)
        {
            for(int j = 0; j < 4-i-1 ; j++)
            {
                double x = (1-t)*temp[j].getX() + t*temp[j+1].getX();
                double y = (1-t)*temp[j].getY()+ t*temp[j+1].getY();
                temp[j] = new Point2D.Double(x,y);
            }
        }
        return temp[0];
    }

    public void drawBezier(Graphics g, ArrayList<Point> p)
    {
        for(double t = 0; t < 1; t+=0.002)
        {
            Point2D p1= cubicBezier(t,p);
            Point2D p2 = cubicBezier(t+0.001,p);
            g.drawLine((int)Math.round(p1.getX()),
                    (int)Math.round(p1.getY()),
                    (int)Math.round(p2.getX()),
                    (int)Math.round(p2.getY()));
        }
    }

    public void paintComponent(Graphics g) {
        if (points == null) return;
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.size(); i++) {
            double x = points.get(i).getX() - SIZE / 2.d;
            double y = points.get(i).getY() - SIZE / 2.d;
            g2.drawString(String.valueOf(i + 1), (float) (x + SIZE), (float) (y + SIZE));
            g2.fill(new Rectangle2D.Double(x, y, SIZE, SIZE));
        }
        drawBezier(g, points);

    }
}

