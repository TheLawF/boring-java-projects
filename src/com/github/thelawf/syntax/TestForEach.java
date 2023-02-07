package com.github.thelawf.syntax;

import com.github.thelawf.logoslib.symbols.AccessModifiers;
import com.github.thelawf.logoslib.symbols.ClassInstanceKeyWords;

import java.util.Objects;

public class TestForEach {

    public static void main(String[] args) {
        String string = "public class MyClass(){\n}";
        String[] elements = string.split(" ");
        AccessModifiers am = new AccessModifiers();
        ClassInstanceKeyWords cWords = new ClassInstanceKeyWords();
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
            if (elements[i].charAt(elements[i].length()-1) == '}') {
                System.out.println("ooooooooo");
            }

            for (int j = 0; j < am.getAllModifiers().length; j++) {
                if (Objects.equals(elements[i], am.getAllModifiers()[j])) {
                    System.out.println("+1");
                }
            }
        }
    }

}
