package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.shorter;

/**
 * @author Canyon
 */
public class CountSubarrays2302 {
    /**
     * sum维护子串的和，len维护子串的长度，当sum*len>=k此时已经不满足条件，移动left
     * @param nums 条件数组
     * @param k 子串的和乘上子串的长度不超过k
     * @return long 所有子串的和乘上子串的长度不超过k的子串的个数
     */
    public long countSubarrays(int[] nums, long k) {
        if(k<=1){
            return 0;
        }
        int left = 0;
        long ans = 0;
        long sum = 0; int len = 0;
        for (int right = 0; right < nums.length; right++) {
            len++;
            sum += nums[right];
            while(sum*len>=k){
                sum -= nums[left++];
                len--;
            }
            ans += right-left+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,3,5};
        System.out.println(new CountSubarrays2302().countSubarrays(arr,10));
    }
}
