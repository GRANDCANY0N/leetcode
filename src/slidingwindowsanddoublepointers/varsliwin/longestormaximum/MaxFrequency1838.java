package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

import java.util.Arrays;

/**
 * @author Canyon
 */
public class MaxFrequency1838 {
    /**
     * 先排序再滑动窗口的思路是对的
     * ❌ 简单的认为维护单个值的窗口
     * ✔ 用total记录从left到right要花费的大小，如果total>k则说明超出范围，要移动left并移除left到right的所有花费
     * @param nums 条件数组
     * @param k 可以选择数字+1的最大操作次数
     * @return int 数组中最高频元素的 最大可能频数
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0; int ans=0; long total = 0;
        for (int right = 0; right < nums.length; right++) {
            if(right>0){
                total += (long) (nums[right]-nums[right-1])*(right-left);
            }
            while(total>k){
                total -= nums[right] - nums[left++];
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
