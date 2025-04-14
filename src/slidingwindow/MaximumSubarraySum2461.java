package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Canyon
 */
public class MaximumSubarraySum2461 {
    /**
     * 用hash表维护不重复值的个数，只有hash表的size和k一样才说明滑动窗口中全是不重复的数
     * @param nums 原数组
     * @param k 滑动窗口的个数
     * @return 返回满足滑动窗口中全部是不重复数的最大值
     */
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(i<k-1){
                continue;
            }
            if(map.size()==k){
                maxSum = Math.max(sum, maxSum);
            }
            int out = nums[i-k+1];
            sum -= out;
            int value = map.get(out);
            if(value>1){
                map.put(out,value-1);
            }else {
                map.remove(out);
            }
        }
        return maxSum;
    }
}
