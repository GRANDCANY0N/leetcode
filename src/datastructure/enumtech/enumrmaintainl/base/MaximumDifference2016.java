package datastructure.enumtech.enumrmaintainl.base;

/**
 * @author Canyon
 * @date 2025/08/19
 */
public class MaximumDifference2016 {
    /**
     * 整体思路：
     * 由于必须是小值在前，大值在后
     * 循环时不断用当前值减去现存的小值，比较是否是最大差值的同时更新当前值和小值之间的最小值
     * -
     * 步骤：
     * 初始化最小值为最大数，ans等于-1
     * 遍历数组，更新ans和当前值减去minNum的最大值，并将minNum更新为与当前值中的较小者
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(1) 常数级变量
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
