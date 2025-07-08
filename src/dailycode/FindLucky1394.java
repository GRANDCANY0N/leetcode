package dailycode;

import java.util.*;

/**
 * @author Canyon
 * @date 2025/07/08
 */
public class FindLucky1394 {
    /**
     * hashMap统计各个数的出现频次，遍历hashMap找到最大的key=value的数
     * 没有返回-1
     * @param arr 数组
     * @return int 返回最大的数字出现频次等于数字值的数，没有返回-1
     */
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        int ans = -1;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (Objects.equals(entry.getValue(), entry.getKey())) {
                ans = Math.max(ans, entry.getValue());
            }
        }
        return ans;
    }
}
