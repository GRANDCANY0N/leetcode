package binarysearch.search.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Canyon
 * @date 2025/06/25
 * 题目是设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值
 * 用hashMap记录key，hashMap的value是list记录timestamp和value的元组
 * java元组需要自己设计，内部类必须是静态，构造元组entry，hashMap的结构是hashMap(key,list(Entry))
 * 由于timestamp严格递增, 则每个key对应的list在timestamp已经是递增的，考虑对list[0]也就是timestamp进行二分，找到对应的key和timestamp对应的值
 * 将要查询的timestamp作为target，小于等于target则是最新的更新过的值
 *
 */
public class TimeMap981  {

    private static class Entry {
        int timestamp;
        String value;

        /**
         * 构造方法 entry
         * @param timestamp 时间戳
         * @param value 值
         */
        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    private final HashMap<String, List<Entry>> map = new HashMap<>();

    public TimeMap981() {

    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        int index = lowerBound(map.get(key),timestamp+1)-1;
        return index < 0 ? "":map.get(key).get(index).value;
    }

    public int lowerBound(List<Entry> list, int target){
        int left = -1;
        int right = list.size();
        while (left + 1 < right) {
            int mid = (left + right) >>>1;
            if(list.get(mid).timestamp<target){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
