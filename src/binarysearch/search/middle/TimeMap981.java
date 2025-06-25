package binarysearch.search.middle;




import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

/**
 * @author Canyon
 * @date 2025/06/25
 */
public class TimeMap981  {

    private static class Entry {
        int timestamp;
        String value;

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
