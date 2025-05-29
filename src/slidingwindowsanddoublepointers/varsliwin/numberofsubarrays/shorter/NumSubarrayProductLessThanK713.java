package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.shorter;

/**
 * @author Canyon
 */
public class NumSubarrayProductLessThanK713 {
    /**
     * 主要是 ans += right - left + 1
     * 如果k小于等于1，此时所有子串的乘积都会大于k 直接返回0
     * 排除这种情况，就要看数组中乘积是否小于等于k
     * 为什么是ans+= right - left + 1，因为每次增加的刚好是left++到right的子串
     * @param nums 条件数组
     * @param k 乘积
     * @return int 所有乘积不超过k值的子串的个数
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int left = 0;
        int ans = 0;
        long multi = 1; int lens = nums.length;
        for (int right = 0; right < lens; right++) {
            multi *= nums[right];
            while(multi>=k){
                multi /= nums[left];
                left++;
            }
            ans = ans + right - left + 1;
        }
        return ans;
    }
}
