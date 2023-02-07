package com.github.thelawf.math;

import java.awt.*;

public class LineSegment {
    public double x1;
    public double y1;
    public double y2;
    public double x2;
    Point dotA;
    Point dotB;
    double length;

    public LineSegment(Point dotA, Point dotB) {
        this.dotA = dotA;
        this.dotB = dotB;
        this.length = MathCalculator.distanceBetweenPoints(this.dotA.getX(),
                this.dotB.getX(), this.dotA.getY(), this.dotB.getY());
    }

    public LineSegment(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.length = MathCalculator.distanceBetweenPoints(this.x1, this.y1, this.x2, this.y2);
    }

    public double getLength() {
        return length;
    }
}
