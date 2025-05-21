package slidingwindowsanddoublepointers.varsliwin.shortestorminimum;

/**
 * @author Canyon
 */
public class MinSubArrayLen209 {
    /**
     * left维护左边，当满足和大于等于target时移动left，并计算子串长度
     * @param target 目标值
     * @param nums 条件数组
     * @return int 最短的子串大于等于target的长度
     */
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
