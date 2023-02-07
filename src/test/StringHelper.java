package test;

import java.awt.*;
import java.util.HashMap;

public class StringHelper {

    public static String toString(HashMap<Point, Point> mapIn) {
        StringBuilder str = new StringBuilder();
        str.append("{Point A -- (");
        for (Point p : mapIn.keySet()) {
            str.append("x = ");
            str.append(p.getX());
            str.append(", ");
            str.append("y = ");
            str.append(p.getY());
            str.append("; ");
        }
        str.append("), Point B -- (");
        for (Point p : mapIn.values()) {
            str.append("x = ");
            str.append(p.getX());
            str.append(", ");
            str.append("y = ");
            str.append(p.getY());
            str.append("; ");
        }
        str.append(")}");
        return str.toString();
    }
}
