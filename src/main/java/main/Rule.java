package main;

import java.util.HashMap;

public class Rule {
    static HashMap<String, Double> map = new HashMap<String, Double>();

    static {
        map.put("電気ノーマル", 1D);
        map.put("電気水", 2D);
        map.put("電気土", 0.5);
        map.put("ノーマル電気", 1D);
        map.put("ノーマルノーマル", 1D);
    }

    public static double decideCompatibility(Attribute attackType, Attribute receiveType) {
        String attackTypeName = attackType.getName();
        String receiveTypeName = receiveType.getName();
        return map.get(attackTypeName + receiveTypeName);
    }
}

