package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.shorter;

public class ContinuousSubarrays2762 {
    /**
     * 写不出来
     * @param nums 条件数组
     * @return ！
     */
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int left = 0;
        int max = Integer.MIN_VALUE;int maxIndex = 0;
        int min = Integer.MAX_VALUE;int minIndex = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] >= max) {
                max = nums[right];
                maxIndex = right;
            }
            if(nums[right] <= min) {
                min = nums[right];
                minIndex = right;
            }
            if(Math.abs(nums[right]-max)>2){
                left = maxIndex+1;
                max = nums[left];
            }
            if(Math.abs(nums[right]-min)>2){
                left = minIndex+1;
                min = nums[left];
            }
            while(Math.abs(nums[right]-nums[left])>2){
                left++;
            }
            ans += right-left+1;
        }
        return ans;
    }

}
