package danmaku;

import java.awt.*;

public class Vector2D {

    double value;
    double x;
    double y;
    double module;

    Point beginning;
    Point ending;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
        this.value = Math.pow(Math.pow(this.x,2) +
                Math.pow(this.y,2),0.5);
    }

    public Vector2D(Point beginning, Point ending){
        this.beginning = beginning;
        this.ending = ending;
        this.value = Math.pow(Math.pow(this.x,2) +
                Math.pow(this.y,2),0.5);
        this.module = Math.pow(this.beginning.x,2) +
                Math.pow(this.beginning.y,2);
    }

    public double getValue() {
        this.value = Math.pow(Math.pow(this.x,2) +
                Math.pow(this.y,2),0.5);
        return this.value;
    }

    public Vector2D flipAxisX(Point beginning, Point ending){
        this.beginning = beginning;
        this.ending = ending;
        this.ending.x = -this.ending.x;
        this.beginning.x = -this.beginning.x;
        return new Vector2D(this.beginning, this.ending);
    }
}
