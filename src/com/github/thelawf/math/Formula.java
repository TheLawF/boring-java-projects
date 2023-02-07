package com.github.thelawf.math;

import java.util.ArrayList;

public class Formula {
    /**
     * Input X and then output Y
     */
    static double x;
    static double y;
    static ArrayList<Double> constants;
    private MathOperators operators;

    public Formula(){

    }

    public static double getX() {
        return x;
    }

    public static double getY() {
        return y;
    }

    // public static ArrayList<Double> getConstants(Formula formulaIn, MathOperators operatorIn) {
    //     switch (operatorIn) {
    //         case PLUS:
    //     }
    // }
//
    // public static Formula plus(Formula... formulas){
    //     for (:
    //          ) {
    //
    //     }
    // }
    //
    public static double plus(double a, double b) {
        return a + b;
    }
}
