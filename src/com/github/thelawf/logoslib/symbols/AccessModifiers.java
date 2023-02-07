package com.github.thelawf.logoslib.symbols;

import java.awt.*;

public class AccessModifiers extends AbstractReservedWord implements IReversedWord{
    public static final String publicModifier = "public";
    public static final String privateModifier = "private";
    public static final String protectedModifier = "protected";
    public static final String[] allModifiers = {publicModifier, privateModifier,protectedModifier};

    public String[] getAllModifiers() {
        return allModifiers;
    }
    @Override
    public Color getHighLightColor(Color colorIn) {
        return super.getHighLightColor(colorIn);
    }
}
