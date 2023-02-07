package RailLines;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Line extends JPanel {
    double angel;
    Point beginning;
    ArrayList<ArrayList<Point>> lines;
    Color color;

    public Line(Point begginning, Point ending, Color color) {
        this.beginning = begginning;
        this.ending = ending;
        this.color = color;
    }

    public Line(ArrayList<ArrayList<Point>> lines, Color color){
        this.lines = lines;
        this.color = color;
    }

    Point ending;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke stroke = new BasicStroke(3.0f);
        g2d.setStroke(stroke);
        g2d.setColor(this.color);
        if (this.lines != null) {
            for (ArrayList<Point> list : lines) {
                for (int i = 0; i < list.size(); i++) {
                    if (i < list.size()-1) {
                        g2d.drawLine(list.get(i).x,
                                list.get(i).y,
                                list.get(i+1).x,
                                list.get(i+1).y);

                    }
                    else {
                        break;
                    }

                }

            }
        }

    }

}
