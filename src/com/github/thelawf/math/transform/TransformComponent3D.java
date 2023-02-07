package com.github.thelawf.math.transform;

import com.github.thelawf.math.RectangularCoordinate;

public abstract class TransformComponent3D implements ITransformable {

    double x;
    double y;
    double z;

    public RectangularCoordinate getTranslate(double x, double y, double z) {
        return new RectangularCoordinate(x, y, z);
    }

    public void translate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
