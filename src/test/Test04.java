package test;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Test04 extends JFrame {
    private static int current;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("BezierTest");
                frame.setSize(264, 360);
                DrawPanel bezier = new DrawPanel();
                bezier.setBorder(new LineBorder(Color.black));
                bezier.setPreferredSize(new Dimension(254, 254));
                frame.add(bezier);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                bezier.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent event) {
                        Point2D p =event.getPoint();
                        for(int i = 0; i < bezier.points.size(); i++)
                        {
                            double x = bezier.points.get(i).getX() - DrawPanel.SIZE / 2.d;
                            double y = bezier.points.get(i).getY() - DrawPanel.SIZE / 2.d;
                            Rectangle2D r = new Rectangle2D.Double(x, y, DrawPanel.SIZE, DrawPanel.SIZE);
                            if(r.contains(p))
                            {
                                current = i;
                                break;
                            }
                        }

                    }
                    public void mouseReleased(MouseEvent event)
                    {
                        current = -1;
                    }

                });

                bezier.addMouseMotionListener(new MouseMotionAdapter()
                {
                    public void mouseDragged(MouseEvent event)
                    {
                        if (current == -1 ) {
                            return;
                        }
                        if(current != -1)
                            // bezier.points.set(current, bezier.points.get(current)) = event.getPoint();
                            frame.repaint();
                    }
                });
                current = -1;

            }
        });
    }

}
