package datastructure.enumtech.enumrmaintainl.base;

/**
 * @author Canyon
 * @date 2025/08/19
 */
public class MaximumDifference2016 {
    /**
     * 整体思路：
     * -
     * 步骤：
     * -
     * 复杂度：
     * - 时间复杂度： O()
     * - 空间复杂度： O()
     * -
     * @param nums 整数数组
     * @return int 返回 nums[j] - nums[i] 能求得的 最大差值
     */
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            ans = Math.max(num-minNum,ans);
            minNum = Math.min(num, minNum);
        }
        return ans>0?ans:-1;
    }
}
