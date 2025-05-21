package slidingwindowsanddoublepointers.varsliwin.shortestorminimum;

/**
 * @author Canyon
 */
public class MinSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;int left=0;
        int ans=Integer.MAX_VALUE;boolean f=false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum<target){
                continue;
            }
            while(sum>=target){
                f=true;
                sum-=nums[left++];
            }
            ans = Math.min(ans,i-left+1);
        }
        return f?ans+1:0;
    }
}
