package count_score;

import java.util.*;

public class Rules {

    public static final String[] colorWan = {"π", "π", "π", "π", "π", "π", "π", "π", "π"};
    public static final String[] colorTiao = {"π", "π", "π", "π", "π", "π", "π", "π", "π"};
    public static final String[] colorTong = {"π", "π", "π", "π", "π", "π", "π", "π ", "π‘"};
    public static final String[] chaWind = {"π", "π", "π", "π"};
    public static final String[] chaArrow = {"π", "π", "π"};
    public static final String [] allcards = {"π", "π", "π", "π","π", "π", "π","π", "π", "π", "π", "π", "π", "π", "π", "π",
            "π", "π", "π", "π", "π", "π", "π", "π", "π","π", "π", "π", "π", "π", "π", "π", "π ", "π‘"};
    String[] mahjong = {"π", "π", "π", "π", "π", "π", "π", "π", "π","π", "π", "π", "π", "π", "π", "π", "π ", "π‘",
            "π", "π", "π", "π", "π", "π", "π", "π", "π","π", "π", "π", "π","π","π","π"};
    /*
    ArrayList<String> wanList = (ArrayList<String>) Arrays.asList(colorWan);
    ArrayList<String> tiaoList = (ArrayList<String>) Arrays.asList(colorTiao);
    ArrayList<String> tongList = (ArrayList<String>) Arrays.asList(colorTong);
    ArrayList<String> windList = (ArrayList<String>) Arrays.asList(chaWind);
    ArrayList<String> arrowList = (ArrayList<String>) Arrays.asList(chaArrow);
    */
    HashMap<Integer, String> map = new HashMap<>();
    ArrayList<Integer> keyList = new ArrayList<>();
    List<String> valueList = Arrays.asList(mahjong);
    String[] result = new String[5];
    String[] triplets = new String[5];
    String[] flushes = new String[5];

    boolean zimo = false;      // θͺζΈ
    boolean bloom = false;     // ζ δΈθ±
    boolean toSpring = false;  // ε¦ζεζ₯
    boolean salvage = false;   // ζ΅·εΊζ
    boolean side = false;      // θΎΉεΌ 
    boolean between = false;   // εεΌ 
    boolean single = false;    // ει
    boolean last = false;      // η»εΌ 
    String roundWind = "π";    // ει£
    String seatWind = "π";     // ι¨ι£

    public static final String[] alones = {"π","π","π","π","π","π‘","π","π","π","π","π","π","π"};
    public static final String[][] lantern = {{"π", "π", "π", "π", "π", "π", "π", "π", "π", "π", "π", "π", "π"},
            {"π","π","π","π","π","π","π","π","π","π","π","π","π"},
            {"π","π","π","π","π","π","π","π","π","π ","π‘","π‘","π‘"}};
    public static final String[] green = {"π", "π", "π", "π", "π", "π"};

    int num = 14;

    String[] groups = new String[5];
    Tools tools = new Tools();
    int score = 1;
    boolean win = false;

    public Rules() {

    }

    public int[] mappingHai(ArrayList<String> hai){
        // ε°ειΊ»ε°ζηδ» ArrayList ζ°ζ?η±»εζ ε°δΈΊ int[]ζ°η»
        int[] integerHai = new int[14];

        for (int i = 0; i < 34; i++) {
            keyList.add(i);
            map.put(keyList.get(i),valueList.get(i));
        }
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            Integer k = entry.getKey();
            String v = entry.getValue();
            for (int j = 0; j < hai.size(); j++) {
                if (Objects.equals(hai.get(j), v)){
                    integerHai[j] = k;
                }
            }
        }
        return integerHai;
    }

    public void getAgariret(List<Integer[][]> agariret){
        //ε°εζ΄εζ°η»ειΊ»ε°ζηθΏεδΈΊε­η¬¦δΈ²εθ‘¨οΌζ΄εζ°εΌθ―·θ§ AgariBacktrack.javaζδ»Άγ
    }

    public String[] mappingStr(List<Integer[][]> intArray){

        keyList.clear();
        map.clear();
        for (int i = 0; i < 34; i++) {
            keyList.add(i);
            map.put(keyList.get(i),valueList.get(i));
        }
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            Integer k = entry.getKey();
            String v = entry.getValue();
            for (Integer[][] r : intArray) {
                if (Objects.equals(k, r[0][0])){
                    result[0] = v;
                }
                for (int j = 0 ;j < r[1].length; j++) {
                    if (Objects.equals(k,r[1][j])){
                        String s = mahjong[k];
                        String str = s;
                        s += s;
                        s += str;
                        triplets[j] = s;
                    }
                }
                for (int j = 0 ;j < r[2].length; j++) {
                    if (Objects.equals(k,r[2][j])){
                        String s = mahjong[k];
                        s += mahjong[k+1];
                        s += mahjong[k+2];
                        flushes[j] = s;
                    }
                }
            }
        }
        int iterTimes = 0;
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i] == null){
                break;
            }
            else {
                result[i+1] = triplets[i];
                iterTimes += 1;
            }
        }
        for (int i = 0; i < flushes.length; i++) {
            if (flushes[i] == null){
                break;
            }
            else {
                result[iterTimes + i + 1] = flushes[i];
            }
        }
        return result;
    }

    public boolean isZimo(boolean zimo){
        this.zimo = zimo;
        return this.zimo;
    }

    public boolean isBloomed(boolean bloom){
        this.bloom = bloom;
        return this.bloom;
    }

    public boolean isToSpring(boolean toSpring){
        this.toSpring = toSpring;
        return this.toSpring;
    }

    public boolean isSalvage(boolean salvage){
        this.salvage = salvage;
        return this.salvage;
    }

    public boolean isSide(boolean side){
        this.side = side;
        return this.side;
    }

}
