package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class MaxSubarrayLength2958 {
    /**
     * 用HashMap来记录每个数字出现的次数，如果有一个数字超过k，则移动left直至这个数字的计数小于k
     * @param nums 条件数组
     * @param k 子串中数字计数不允许超过的范围
     * @return int 最长满足各个数字不超过k的字串长度
     */
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0; int left = 0;int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num,1,Integer::sum);
            sum++;
            while(map.get(num)>k){
                map.merge(nums[left],-1,Integer::sum);
                sum--;
                left++;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
