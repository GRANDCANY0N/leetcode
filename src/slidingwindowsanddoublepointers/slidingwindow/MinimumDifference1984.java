package slidingwindowsanddoublepointers.slidingwindow;

import java.util.Arrays;

/**
 * @author Canyon
 */
public class MinimumDifference1984 {
    /**
     * 先排序，就变成了模板题
     * @param nums 原数组
     * @param k 滑动窗口的长度，但是可以不连续
     * @return 滑动窗口中最小的最大最小差值
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 9999999;
        for (int i = 0; i < nums.length; i++) {
            if(i<k-1){
                continue;
            }
            min = Math.min(min, nums[i] - nums[i-k+1]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {9,4,1,7};
        System.out.println(new MinimumDifference1984().minimumDifference(arr,2));
    }
}
