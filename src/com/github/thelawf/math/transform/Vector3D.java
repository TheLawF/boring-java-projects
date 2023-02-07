package com.github.thelawf.math.transform;

import com.github.thelawf.math.MathCalculator;

public class Vector3D {
    double x;
    double y;
    double z;

    double length;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = MathCalculator.toModulus3D(this.x, this.y, this.z);
    }

    public Vector3D rotatePitch(float pitch) {
        float f = (float) Math.cos(pitch);
        float f1 = (float) Math.sin(pitch);
        double d0 = this.x;
        double d1 = this.y * (double)f + this.z * (double)f1;
        double d2 = this.z * (double)f - this.y * (double)f1;
        return new Vector3D(d0, d1, d2);
    }

    public Vector3D rotateYaw(float yaw) {
        float f = (float) Math.cos(yaw);
        float f1 = (float) Math.sin(yaw);
        double d0 = this.x * (double)f + this.z * (double)f1;
        double d1 = this.y;
        double d2 = this.z * (double)f - this.x * (double)f1;
        return new Vector3D(d0, d1, d2);
    }

    public Vector3D rotateRoll(float roll) {
        float f = (float) Math.cos(roll);
        float f1 = (float) Math.sin(roll);
        double d0 = this.x * (double)f + this.y * (double)f1;
        double d1 = this.y * (double)f - this.x * (double)f1;
        double d2 = this.z;
        return new Vector3D(d0, d1, d2);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getLength() {
        return length;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x = " + x +
                ", y = " + y +
                ", z = " + z +
                '}';
    }
}
