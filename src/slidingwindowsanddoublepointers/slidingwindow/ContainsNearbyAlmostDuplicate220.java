package slidingwindowsanddoublepointers.slidingwindow;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class ContainsNearbyAlmostDuplicate220 {

    /**
     * 桶排序 二分 不会
     * @param nums 原数组
     * @param indexDiff 目标索引
     * @param valueDiff 目标值
     * @return boolean
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int left = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        long dif = -nums[0];
        for (int right = 0; right < nums.length; right++) {
//            dif +
        }
        return false;
    }
}
