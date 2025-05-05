package dailycode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Canyon
 */
public class NumEquivDominoPairs1128 {
    /**
     * 把每个一维数组都用集合判别，存入hashMap
     * @param dominoes 多米诺数组
     * @return int 符合条件的个数
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        HashMap<Set<Integer>, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            Set<Integer> set = new HashSet<>();
            set.add(d[0]);
            set.add(d[1]);
            int value = map.merge(set, 1, Integer::sum);
            ans += value - 1;
        }
        return ans;
    }
}
