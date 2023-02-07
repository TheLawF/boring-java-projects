package com.github.thelawf.math;


import java.awt.*;

public class Triangle2D {
    Point vertexA;
    Point vertexB;
    Point vertexC;

    LineSegment sideA;
    LineSegment sideB;
    LineSegment sideC;

    double sideLength;
    double area;

    double angleAlpha;
    double angelBeta;
    double angelGamma;

    public Triangle2D(Point vertexA, Point vertexB, Point vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;

        this.sideA = new LineSegment(vertexB, vertexC);
        this.sideB = new LineSegment(vertexA, vertexC);
        this.sideC = new LineSegment(vertexA, vertexB);

        this.sideLength = this.sideA.length + this.sideB.length + this.sideC.length;
    }

    public Triangle2D(LineSegment sideA, LineSegment sideB, LineSegment sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle2D(double angleAlpha, double angelBeta, double angelGamma) {
        this.angleAlpha = angleAlpha;
        this.angelBeta = angelBeta;
        this.angelGamma = angelGamma;
    }

    public Triangle2D(double angleAIn, double angleBIn, LineSegment anySideIn){

    }

    public Triangle2D(LineSegment sideAIn, double includeAngleIn, LineSegment sideBIn) throws TriangleNotUniqueException, TriangleDoNotExistException {
        for (int i = 0; i < 2; i++) {
            double angleB = Math.asin(sideBIn.getLength() * Math.sin(includeAngleIn) / sideAIn.getLength());
            // double angleB1 = Math.asin(sideAIn.getLength() * Math.sin(includeAngleIn) / sideBIn.getLength());
            if (sideAIn.getLength() == angleB * Math.sin(includeAngleIn)) {
                double angleC = 360d - angleB - includeAngleIn;
                this.angleAlpha = includeAngleIn;
                this.angelBeta = angleB;
                this.angelGamma = angleC;
            }
            else if (sideAIn.getLength() >= sideBIn.getLength() * Math.sin(includeAngleIn)) {
                throw new TriangleNotUniqueException("Δ>0，三角形不唯一，存在着两个三角形的备选值");
            }
            else if (sideAIn.getLength() <= sideBIn.getLength() * Math.sin(includeAngleIn)) {
                throw new TriangleDoNotExistException("Δ<0, 三角形不存在");
            }
        }

    }

    public static RectangularCoordinate initTriangleLineRaw(double lengthA, double lengthB, double lengthC) {
        return new RectangularCoordinate(lengthA, lengthB, lengthC);
    }

    public static Triangle2D initTriangleByLength(double lengthA, double includeAngleIn, double lengthB) throws TriangleDoNotExistException, TriangleNotUniqueException {
        for (int i = 0; i < 2; i++) {
            double angleB = Math.asin(lengthB * Math.sin(includeAngleIn) / lengthA);
            // double angleB1 = Math.asin(sideAIn.getLength() * Math.sin(includeAngleIn) / sideBIn.getLength());
            if (lengthA == angleB * Math.sin(includeAngleIn)) {
                double angleC = 360d - angleB - includeAngleIn;
                return new Triangle2D(includeAngleIn, angleB, angleC);
            }
            else if (lengthA >= lengthB * Math.sin(includeAngleIn)) {
                throw new TriangleNotUniqueException("Δ>0，三角形不唯一，存在着两个三角形的备选值");
            }
            else if (lengthA <= lengthB * Math.sin(includeAngleIn)) {
                throw new TriangleDoNotExistException("Δ<0, 三角形不存在");
            }
        }
        return new Triangle2D(lengthA, includeAngleIn, lengthB);
    }

    public double getAngleAlpha() {
        return angleAlpha;
    }

    public double getAngelBeta() {
        return angelBeta;
    }

    public double getAngelGamma() {
        return angelGamma;
    }

    public Point getVertexA() {
        return vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }

    public LineSegment getSideA() {
        return sideA;
    }

    public LineSegment getSideB() {
        return sideB;
    }

    public LineSegment getSideC() {
        return sideC;
    }

    public double getArea() {
        return area;
    }

    public double getSideLength() {
        return sideLength;
    }

    public static class RightTriangle2D extends Triangle2D {

        /**
         *
         * @param angleAlpha angle alpha, as so called A;
         * @param angelBeta angle beta, as so called B;
         * @param angelGamma angle gamma, expected 90 degrees in;
         * @throws TriangleDoNotExistException Not a valid RightTriangle value
         */
        public RightTriangle2D(double angleAlpha, double angelBeta, double angelGamma) throws TriangleDoNotExistException {
            super(angleAlpha, angelBeta, angelGamma);
            if (angelGamma != 90.0d) {
                throw new TriangleDoNotExistException("不是合法的直角三角形，原因：∠C = " + angelGamma);
            }
        }

        public RightTriangle2D(LineSegment sideA, LineSegment sideB, LineSegment sideC) throws TriangleDoNotExistException {
            super(sideA, sideB, sideC);
            if (sideA.getLength() + sideB.getLength() < sideC.getLength()) {
                throw new TriangleDoNotExistException("不是合法的直角三角形，原因：边A + 边B < 边C");
            }
            else if (sideC.length != MathCalculator.toModulus2D(sideA.length, sideB.length)) {
                throw new TriangleDoNotExistException("不是合法的直角三角形，原因：a^2 + b^2 不等于 c^2");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Δ: vertex_A {%s}, vertex_B {%s}, vertex_C{%s}\n" +
                        "angle_alpha {%s}, angle_beta {%s}, angle_gamma {%s}",
                vertexA.toString(), vertexB.toString(), vertexC.toString(),
                angleAlpha, angelBeta, angelGamma);
    }
}
