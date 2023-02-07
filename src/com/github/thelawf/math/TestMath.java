package com.github.thelawf.math;

import com.github.thelawf.math.transform.Vector3D;

public class TestMath {

    public static void main(String[] args) throws PointNonExistException {
        // RectangularCoordinate coor1 = new RectangularCoordinate(200, 64, 200);
        // RectangularCoordinate pivot = new RectangularCoordinate(100, 64, 100);
        // for (int i = 0; i < 5; i++) {
        //     LineSegment hypotenuse = new LineSegment(coor1.x, coor1.z, pivot.x,pivot.z);
        //     Vector3D prevVec = new Vector3D(coor1.x, coor1.y, coor1.z);
        //     Vector3D newVec = prevVec.rotateYaw((float) Math.PI / 12 * i);
        //     System.out.println(newVec);
        // }
//
        // System.out.print("Input Here: ");
        // Scanner sc = new Scanner(System.in);
        // String line = sc.nextLine();
//
        // String regex = "[^0-9]";
        // Pattern p = Pattern.compile(regex);
        // Matcher m = p.matcher(line);
//
        // if (line.matches("^-?\\d+$")) {
        //     System.out.println(line);
        // }
        // else {
        //     String str = m.replaceAll("").trim();
        //     System.out.println(str);
        // }

        double pix = 3;
        double seg = 10 * pix;
        LineSegment3D lLength = new LineSegment3D(391.0,211.0,0,394.0,289.0,0);
        LineSegment3D lWidth = new LineSegment3D(305.0,179.0,0,517.0,268.0,0);
        // intersect point in visual: 396, 245
        // intersect point in calc: 391, 215
        Vector3D iBasis = new Vector3D(lWidth.x1/seg,0,0);
        Vector3D jBasis = new Vector3D(0,0,lLength.z1/seg);

        RectangularCoordinate coord = MathCalculator.getIntersectPoint3D(lLength, lWidth);
        System.out.println(coord);
        System.out.println(coord);

        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            if (arr.length % 2 == 0) {
                System.out.println(i);
                i++;
            }
            else {
                System.out.println(i);
            }
        }
    }

    // public static double formula(double x) {
    //     return Math.floor(Math.sin(x));
    // }

}
