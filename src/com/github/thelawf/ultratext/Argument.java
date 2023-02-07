package com.github.thelawf.ultratext;

public abstract class Argument implements IElement<Argument> {
    boolean condition;
    public abstract void run();
}
