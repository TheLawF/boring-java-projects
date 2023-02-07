package RailLines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class LineSurface extends JPanel {
    Point point;
    ArrayList<Point> stations;
    ArrayList<ArrayList<Point>> lines;
    public LineSurface(){

    }

    public ArrayList<ArrayList<Point>> getPoint() {

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                point = e.getPoint();
                stations.add(point);
                lines.add(stations);
            }
        });
        return this.lines;
    }
}