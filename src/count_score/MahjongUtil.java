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


    protected static final String CONSTANT = "\uD83C";
    protected static final ArrayList<String> allMahjong = new ArrayList<>(Arrays.asList(Rules.allcards));

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
        pattern = pattern.toLowerCase();
        HashMap<String, String> formatMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        list = getStrings(pattern, formatMap, list, MAN_ZU);
        list = getStrings(pattern, formatMap, list, PIN_ZU);
        list = getStrings(pattern, formatMap, list, SOU_ZU);
        list = getStrings(pattern, formatMap, list, CHARACTER_HAI);

        if (list.size() != 0 && StringLogic.containsPair(list.get(0), FULU_START, FULU_END)) {
            formatMap.put(FULU_START, StringLogic.getStringBetween(list.get(0),
                    FULU_START, FULU_END));
        }
        return formatMap;
    }

    public static String toMahjongString(String pattern) {
        HashMap<String, String> formatMap = getMahjongFormatMap(pattern);
        StringBuilder builder = new StringBuilder();
        buildStringIfContainsKey(formatMap, builder, MAN_ZU);
        buildStringIfContainsKey(formatMap, builder, PIN_ZU);
        buildStringIfContainsKey(formatMap, builder, SOU_ZU);
        buildStringIfContainsKey(formatMap, builder, CHARACTER_HAI);

        return builder.toString();
    }

    public static ArrayList<String> toMahjongList(String pattern) {
        String mahjongString = toMahjongString(pattern);
        ArrayList<String> mahjongList = new ArrayList<>();
        for (int i = 0; i < mahjongString.length(); i++) {
            mahjongList.add(String.valueOf(mahjongString.charAt(i)));
        }
        return mahjongList;
    }
    // public static String toPatternString(String mahjong) {
    //     StringBuilder builder = new StringBuilder();
    //     return builder.toString();
    // }

    private static void buildStringIfContainsKey(HashMap<String, String> formatMap, StringBuilder builder, String key) {
        if (formatMap.containsKey(key)) {
            if (Objects.equals(key, MAN_ZU)) {
                String s = formatMap.get(key);
                int unicode;
                for (int j = 0; j < s.length(); j++) {
                    unicode = s.charAt(j) + 56278;
                    builder.append(CONSTANT);
                    builder.append((char) unicode);
                }
            }
            if (Objects.equals(key, PIN_ZU)) {
                String s = formatMap.get(key);
                int unicode;
                for (int j = 0; j < s.length(); j++) {
                    unicode = s.charAt(j) + 56296;
                    builder.append(CONSTANT);
                    builder.append((char) unicode);
                }
            }
            if (Objects.equals(key, SOU_ZU)) {
                String s = formatMap.get(key);
                int unicode;
                for (int j = 0; j < s.length(); j++) {
                    unicode = s.charAt(j) + 56287;
                    builder.append(CONSTANT);
                    builder.append((char) unicode);
                }
            }
            if (Objects.equals(key, CHARACTER_HAI)) {
                String s = formatMap.get(key);
                int unicode;
                for (int j = 0; j < s.length(); j++) {
                    unicode = s.charAt(j) + 56271;
                    builder.append(CONSTANT);
                    builder.append((char) unicode);
                }
            }
        }
    }

    private static ArrayList<String> getStrings(String pattern, HashMap<String, String> formatMap, ArrayList<String> list, String characterHai) {
        if (list.size() == 0) {
            if (pattern.contains(characterHai)) {
                list = new ArrayList<>(Arrays.asList(pattern.split(characterHai)));
                System.out.println(list);
                formatMap.put(characterHai, list.get(0));
                list.remove(0);
            }
        }
        else if (pattern.contains(characterHai)) {
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(list.get(0).split(characterHai)));
            formatMap.put(characterHai, arrayList.get(0));
            arrayList.remove(0);
            list = arrayList;
        }
        return list;
    }

}
