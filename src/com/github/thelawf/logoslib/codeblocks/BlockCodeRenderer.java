package com.github.thelawf.logoslib.codeblocks;

import com.github.thelawf.logoslib.symbols.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class BlockCodeRenderer {
    public String scriptsOrigin;
    public AbstractReservedWord wordIn;

    public BlockCodeRenderer(Color color) {
    }


    public String renderColorByType(Font font, String scriptsIn) {
        String packageBlock = "";
        String importBlock = "";
        String processBlock = "";
        String threadBlock = "";
        String mainBlock = "";
        String constructorBlock = "";

        StringBuilder strFormat = new StringBuilder();
        AccessModifiers am = new AccessModifiers();
        ClassInstanceKeyWords cWords = new ClassInstanceKeyWords();
        ReturnTypes types = new ReturnTypes();

        // 渲染开始，首先将原字符串以空格拆分为数组，再将数组以回车符号拆分为二维列表
        // 列表的长度表示原代码的行数，列表内列表的元素个数为代码单元；
        ArrayList<ArrayList<String>> scriptLines = new ArrayList<>();

        // 将代码输出为 HTML格式的准备；

        HashMap<String,String> htmlMap = new HashMap<>();


        for (int i = 0; i < scriptsIn.split("\n").length; i++) {

            String[] elements = scriptsIn.split("\n")[i].split(" ");
            ArrayList<String> htmls = new ArrayList<>();
            for (int j = 0; j < elements.length; j++) {
                // 获取代码元素，格式化渲染开始
                String copy = elements[j];
                elements[j] = "<font size=\"6\" color=\"black\">" + copy + " ";
                htmls.add(elements[j]);

                for (int k = 0; k < am.getAllModifiers().length; k++) {
                    // 判断元素是否为访问修饰符，且是否为本行第一个元素
                    if (Objects.equals(copy, am.getAllModifiers()[k]) && j == 0) {
                        String html = "<p><font size=\"6\" color=\"blue\">" + copy + "</font> ";
                        htmls.set(j,html);
                        System.out.println("????");
                    }
                    else if (Objects.equals(copy, am.getAllModifiers()[k]) && j != 0) {
                        String html = "<font size=\"6\" color=\"blue\">" + copy + "</font> ";
                        htmls.set(j,html);
                    }
                }

                for (int k = 0; k < cWords.getAllKeyWords().length; k++) {
                    if (Objects.equals(copy, cWords.getAllKeyWords()[k]) && j == 0) {
                        String html = "<p><font size=\"6\" color=\"blue\">" + copy + "</font> ";
                        htmls.set(j,html);
                    }
                    else if (Objects.equals(copy, cWords.getAllKeyWords()[k]) && j != 0) {
                        String html = "<font size=\"6\" color=\"blue\">" + copy + "</font> ";
                        htmls.set(j,html);
                    }
                }
            }
            // 二维列表内的一维列表循环结束后，为一维列表最后一个字符加上HTML段落结束标记 -- "</p>"
            htmls.set(htmls.size()-1, htmls.get(htmls.size()-1) + "</p>\n");
            scriptLines.add(htmls);
        }

        for (ArrayList<String> list : scriptLines) {
            for (String each : list) {
                strFormat.append(each);
            }
        }
        /*
        int beginning = 0;
        int ending = 0;
        for (int i = 0;i < elements.length;i++) {
            String htmlFormat = "";
            ending += elements[i].length() + i;
            for (Object modifier : am.getAllModifiers()) {
                if (elements[i] == modifier) {
                    beginning = ending - elements[i].length();
                    break;
                }
            }
        }
         */

        return strFormat.toString();
    }

}
