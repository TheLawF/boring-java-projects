package danmaku;

import java.awt.*;

public class Danmaku {
    int x;
    int y;
    int width;
    int height;
    double angle;
    int speed;
    int size;
    Point center;
    double vectorX = 2d;
    double vectorY = 3d;
    double dotX;
    double dotY;

    public Danmaku(int x,int y,int speed,int size){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
        this.dotX = (double) x;
        this.dotY = (double) y;

    }

    public Point getCenter(int width,int height) {
        this.width = width;
        this.height = height;
        this.center.x = this.width / 2;
        this.center.y = this.height / 2;
        return this.center;
    }
}
