package dailycode;

import java.util.Arrays;

/**
 * @author Canyon
 * @date 2025/07/14
 */
public class FindLHS594 {
    /**
     * 先对数组排序，用滑动窗口解决
     * 当left索引的值小于right时，此时移动left直至nums[right] - nums[left] <= 1,最多left=right 所以不会超出范围
     * 再判断此时的nums[right] - nums[left]是不是恰好等于1，如果等于则和ans进行比较取最大的
     * 注：left只会移动到相同值的最左边
     * @param nums 整数数组
     * @return int 返回一个序列里最大值和最小值之间的差别 正好是 1的最大的序列长度
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while(nums[right]-nums[left]>1){
                left++;
            }
            if(nums[right]-nums[left]==1){
                ans = Math.max(ans,right-left+1);
            }
        }
        return ans;
    }
}
