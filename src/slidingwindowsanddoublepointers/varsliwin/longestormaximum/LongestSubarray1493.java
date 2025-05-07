package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

/**
 * @author Canyon
 */
public class LongestSubarray1493 {
    /**
     * 开辟一个数组记录0和1的数量，当0数量达到2时移动left，并将滑过的0 1 计数进行减少
     * 由于i停留的这个0不会参与最长比较，所以结果是i-left而不是i-left+1
     * @param nums 条件数组
     * @return int 删除一个数后最长的全1数组长度
     */
    public int longestSubarray(int[] nums) {
        int ans = 0;int left = 0;
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]]++;
            while(ints[0]>1){
                ints[nums[left++]]--;
            }
            ans = Math.max(i-left,ans);
        }
        return ans;
    }
}
