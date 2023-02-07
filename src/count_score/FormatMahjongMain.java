package count_score;

import java.util.HashMap;
import java.util.Scanner;

public class FormatMahjongMain {
    public static void main(String[] args) {
        System.out.print("请输入麻将格式化代码：");
        Scanner scanner = new Scanner(System.in);
        System.out.println(MahjongUtil.toMahjongString(scanner.next()));
        // System.out.println(mahjongMap.keySet());
        // System.out.println(mahjongMap.values());

        // String numUnicode = "\u0031 - \u0039"; // 1-9
        // String man = "\uD83C\uDC07 - \uD83C\uDC0F"; // 万字
        // String pin = "\uD83C\uDC19 - \uD83C\uDC21"; // 饼子
        // String sou = "\uD83C\uDC10 - \uD83C\uDC18"; // 索子
        // String zu = "\uD83C\uDC00 - \uD83C\uDC06"; // 字牌
        // String flower = "\uD83C\uDC22 - \uD83C\uDC29"; // 花牌
        // String baiDa = "\uD83C\uDC2A"; // 百搭
        // String back = "\uD83c\uDC2B"; // 牌背
        // System.out.println(0xdc19 - 0x0031);
    }
}
