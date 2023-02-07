package com.github.thelawf.ultratext;

import java.util.function.Supplier;

public class IfBranch extends Argument {

    public IfBranch(Supplier<?> supplier) {
    }

    @Override
    public void run() {

    }

    @Override
    public Argument get() {
        return this;
    }
}
