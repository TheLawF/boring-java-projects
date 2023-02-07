package practice;

import java.util.HashMap;

public class DanmakuStyle {
    HashMap<String, HashMap<String, Object>> muzzles;
    TransformFunctionJson functionJson;

    public DanmakuStyle(HashMap<String, HashMap<String, Object>> muzzles,
                        TransformFunctionJson functionJson) {
        this.muzzles = muzzles;
        this.functionJson = functionJson;
    }
}
