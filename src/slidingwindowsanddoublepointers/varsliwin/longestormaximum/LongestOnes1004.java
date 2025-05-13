package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

/**
 * @author Canyon
 */
public class LongestOnes1004 {
    /**
     * 标准的最大最长滑动窗口解题方法
     * @param nums 条件数组
     * @param k 允许将0变为1的最大次数
     * @return int 最长1子串
     */
    public int longestOnes(int[] nums, int k) {
        int ans=0;int left=0;
        int[] ints = new int[2];
        for (int right = 0; right < nums.length; right++) {
            ints[nums[right]]++;
            if(ints[0]>k){
                ints[nums[left++]]--;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
