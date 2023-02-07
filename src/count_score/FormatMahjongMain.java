package count_score;

import java.util.HashMap;
import java.util.Scanner;

public class FormatMahjongMain {
    public static void main(String[] args) {
        System.out.print("请输入麻将格式化代码：");
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> mahjongMap = MahjongUtil.getMahjongFormatMap(scanner.next());
        System.out.println(mahjongMap.keySet());
        System.out.println(mahjongMap.values());
    }
}
