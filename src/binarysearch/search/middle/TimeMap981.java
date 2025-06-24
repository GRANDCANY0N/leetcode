package binarysearch.search.middle;




import java.util.HashMap;

import java.util.TreeMap;

public class TimeMap981  {


    private final HashMap<String, TreeMap<Integer,String>> map = new HashMap<>();

    public TimeMap981() {

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            TreeMap<Integer, String> innerMap = new TreeMap<>();
            innerMap.put(timestamp, value);
            map.put(key, innerMap);
        }else {
            map.get(key).put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> innerMap = map.get(key);
        HashMap.Entry<Integer, String> entry = innerMap.floorEntry(timestamp);
        return entry != null ? entry.getValue() : "";

    }
}
