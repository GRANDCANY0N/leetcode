package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.longer;

/**
 * @author Canyon
 */
public class CountSubarrays2962Two {
    /**
     * 先遍历数组找到最大值
     * 第二次遍历数组，cntMax维护最大值的次数，当cntMax>=k时
     * 移动left
     * @param nums 条件数组
     * @param k 最大值出现至少出现的次数k
     * @return long 所有包含最大值满足k的子串个数
     */
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num,max);
        }
        int left = 0;
        long ans = 0;
        int cntMax = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right]==max){
                cntMax++;
            }
            while(cntMax>=k){
                if(nums[left]==max){
                    cntMax--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
