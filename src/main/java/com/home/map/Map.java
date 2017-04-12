package com.home.map;

import java.util.HashMap;

/**
 * Created by FDR on 23.03.2017.
 */
public class Map {
    public static void main(String[] args) {
        java.util.Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("key", 1);
        map.put("key1", 2);
        System.out.println(map);
        System.out.println(map.get("key"));
    }
}
