package com.github.thelawf.math.transform;


import com.github.thelawf.math.RectangularCoordinate;

public class PivotPoint3D extends TransformComponent3D {
    double pivotX;
    double pivotY;
    double pivotZ;

    @Override
    public void translate(double x, double y, double z) {
        this.pivotX = x;
        this.pivotY = y;
        this.pivotZ = z;
    }

    public RectangularCoordinate toLocalCoord(RectangularCoordinate globalIn) {
        return new RectangularCoordinate(this.pivotX -= globalIn.x, this.pivotY -= globalIn.y, this.pivotZ -= globalIn.z);
    }

    public RectangularCoordinate toLocalCoord(double xIn, double yIn, double zIn) {
        return toLocalCoord(new RectangularCoordinate(xIn, yIn, zIn));
    }

}
