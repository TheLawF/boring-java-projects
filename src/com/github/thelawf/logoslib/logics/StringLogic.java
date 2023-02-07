package com.github.thelawf.logoslib.logics;

public class StringLogic {

    public static boolean containsPair(String original, String startPattern, String endPattern) {
        return original.contains(startPattern) && original.contains(endPattern);
    }

    public static String getStringBetween(String original, String startPattern, String endPattern) {
        String start = "";
        String end = "";
        for (int i = 0; i < original.length(); i++) {
            if (original.contains(startPattern)) {
                start = original.replace(startPattern, "");
            }
            if (!start.equals("") && original.contains(endPattern)) {
                end = start.replace(endPattern, "");
            }
        }
        return end;
    }
}
