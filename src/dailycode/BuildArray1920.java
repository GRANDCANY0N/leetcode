package dailycode;

/**
 * @author Canyon
 */
public class BuildArray1920 {
    /**
     * 符合要求遍历
     * @param nums 原数组
     * @return {@link int[] } 按要求排序后的数组
     */
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
