package count_score;

import com.github.thelawf.logoslib.logics.StringLogic;

import java.util.*;

public class MahjongUtil {

    protected static final String MAN_ZU = "m";
    protected static final String PIN_ZU = "p";
    protected static final String SOU_ZU = "s";
    protected static final String RED = "0";
    protected static final String CHARACTER_HAI = "z";

    protected static final String FULU_START = "f/";
    protected static final String FULU_END = "/";

    protected static final String[] cardArray = {"🀀", "🀁", "🀂", "🀃","🀄", "🀅", "🀆","🀇", "🀈", "🀉", "🀊", "🀋", "🀌", "🀍", "🀎", "🀏","🀐", "🀑", "🀒", "🀓", "🀔", "🀕", "🀖", "🀗", "🀘",
            "🀙", "🀚", "🀛", "🀜", "🀝", "🀞", "🀟", "🀠", "🀡"};
    protected static final List<String> allMahjongs =  Arrays.asList(cardArray);

    public static StringBuilder formatMahjongArray(List<String> mahjongList,
                                                   List<String> chiList,
                                                   List<String> pengList,
                                                   List<String> gangList) {
        StringBuilder builder = new StringBuilder();
        buildListString(mahjongList, builder, MAN_ZU, PIN_ZU);
        buildListString(mahjongList, builder, SOU_ZU, CHARACTER_HAI);

        builder.append(FULU_START);
        // for (int i = 0; i < chiList.size(); i++) {
        //     // getMahjongFormatMap(chiList.get(i));
        // }

        return builder;
    }

    private static void buildListString(Collection<String> mahjongList, StringBuilder builder,
                                        String identifier1, String identifier2) {
        for (int i = 0; i < 9; i++) {
            if (mahjongList.contains(String.valueOf(i))) {
                builder.append(i+1);
                break;
            }
        }
        builder.append(identifier1);

        for (int i = 0; i < 9; i++) {
            if (mahjongList.contains(String.valueOf(i))) {
                builder.append(i+1);
                break;
            }
        }
        builder.append(identifier2);
    }

    public static HashMap<String, String> getMahjongFormatMap(String pattern) {
        HashMap<String, String> formatMap = new HashMap<>();

        ArrayList<String> list = new ArrayList<>();
        if (pattern.contains(MAN_ZU)) {
            ArrayList<String> l1 = new ArrayList<>(Arrays.asList(pattern.split(MAN_ZU)));
            formatMap.put(MAN_ZU, l1.get(0));
            System.out.println(list);
            l1.remove(0);
            list = l1;
        }

        if (pattern.contains(PIN_ZU)) {
            ArrayList<String> l2 = new ArrayList<>(Arrays.asList(list.get(0).split(PIN_ZU)));
            formatMap.put(PIN_ZU, l2.get(0));
            System.out.println(list);
            l2.remove(0);
            list = l2;
        }

        if (pattern.contains(SOU_ZU)) {
            ArrayList<String> l3 = new ArrayList<>(Arrays.asList(list.get(0).split(SOU_ZU)));
            formatMap.put(SOU_ZU, l3.get(0));
            System.out.println(list);
            l3.remove(0);
            list = l3;
        }

        if (pattern.contains(CHARACTER_HAI)) {
            ArrayList<String> l4 = new ArrayList<>(Arrays.asList(list.get(0).split(CHARACTER_HAI)));
            formatMap.put(CHARACTER_HAI, l4.get(0));
            System.out.println(list);
            l4.remove(0);
            list = l4;
        }

        System.out.println(list.get(0).contains(FULU_END));
        if (list.size() != 0 && StringLogic.containsPair(list.get(0), FULU_START, FULU_END)) {
            formatMap.put(FULU_START, StringLogic.getStringBetween(list.get(0),
                    FULU_START, FULU_END));
        }
        return formatMap;
    }

}
