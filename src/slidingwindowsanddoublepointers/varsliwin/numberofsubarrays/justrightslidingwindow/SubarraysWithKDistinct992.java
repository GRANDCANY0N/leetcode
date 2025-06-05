package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.justrightslidingwindow;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class SubarraysWithKDistinct992 {
    /**
     * 标准的至少型滑动窗口与hashMap的结合
     * @param nums 条件数组
     * @param k 恰好不同数的个数
     * @return int 所有子串中不同数的个数恰好等于k的子串个数
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solution(nums,k) - solution(nums,k+1);
    }
    public int solution(int[] nums, int k){
        int left = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num,1,Integer::sum);
            while(map.size()>=k){
                int value = map.get(nums[left]);
                if(value > 1){
                    map.put(nums[left],value-1);
                }else {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
