package com.github.thelawf.math.transform;

import java.awt.geom.AffineTransform;

public class TestTransformObject {

    public static void main(String[] args) {
        AffineTransform tran = AffineTransform.getRotateInstance(Math.PI / 2, 20, 20);
        System.out.println(tran);
    }
}
