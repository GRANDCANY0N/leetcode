package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.justrightslidingwindow;

/**
 * @author Canyon
 */
public class NumberOfSubarrays1248 {
    /**
     * 标准的恰好型滑动窗口
     * @param nums 条件数组
     * @param k 恰好奇数个数字的个数
     * @return int 所有的恰好k个奇数个数字的子串个数
     */
    public int numberOfSubarrays(int[] nums, int k) {
        return solution(nums,k) - solution(nums,k+1);
    }
    public int solution(int[] nums, int k){
        int left = 0;
        int ans = 0;
        int cnt = 0;
        for (int num : nums) {
            if(num%2!=0){
                cnt++;
            }
            while(cnt>=k){
                if(nums[left]%2!=0){
                    cnt--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
