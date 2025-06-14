package binarysearch.search.base;

public class SearchInsert35 {
    public int lower_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left+1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
    /**
     * 大于等于target
     * @param nums 条件数组
     * @param target 目标值
     * @return int 目标值的索引
     */
    public int searchInsert(int[] nums, int target) {
        return lower_bound(nums, target);
    }
}
