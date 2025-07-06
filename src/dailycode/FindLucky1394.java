package dailycode;

import java.util.*;

public class FindLucky1394 {
    /**
     * @param arr 数组
     * @return int
     */
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (Objects.equals(entry.getValue(), entry.getKey())) {
                ans = Math.max(ans, entry.getValue());
            }
        }
        return ans;
    }
}
