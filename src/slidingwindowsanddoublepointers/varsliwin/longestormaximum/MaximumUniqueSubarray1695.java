package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

import java.util.HashSet;

/**
 * @author Canyon
 */
public class MaximumUniqueSubarray1695 {
    /**
     * 用set管理字串的重复情况，当出现重复时，移动left直至将重复的值从set中移除
     * @param nums 条件数组
     * @return int 不重复字串的最大和
     */
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;int left = 0;int sum=0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            while (!set.add(num)) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            sum += num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
