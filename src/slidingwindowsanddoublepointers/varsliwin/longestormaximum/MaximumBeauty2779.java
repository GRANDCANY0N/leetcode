package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

import java.util.Arrays;

/**
 * @author Canyon
 */
public class MaximumBeauty2779 {
    private static final Integer NUM = 2;

    /**
     * 第一种想法是暴力，用hashMap攘括每个值的范围，最后取最大值，超时
     * 第二种是先排序，用滑动窗口的思想，当nums[right]-nums[left]的差超过2*k时，说明此时不存在交集，要开始移动left直至差小于2k
     * 此时的[left,right]之间的数都有交集
     * @param nums 条件数组
     * @param k 每个数可以取到[nums[i] - k, nums[i] + k]
     * @return int 数组中由相等元素组成的最长子序列的长度
     */
    public int maximumBeauty(int[] nums, int k) {
        int ans=0;int left=0;
        Arrays.sort(nums);
        for (int right = 0; right < nums.length; right++) {
            while(nums[right]-nums[left]> NUM*k){
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
