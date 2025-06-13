package binarysearch.search.base;

/**
 * 考虑四种情况 >= > < <= 都考虑target存在于数组中的情况
 * 大于等于target>= 此时索引right就是等于target start = lower_bound(nums,target)
 * 大于target> 如果数组全是整数，我们可以当作去找target+1这个数，如果存在则此时的right就是要找的索引  start = lower_bound(nums,target+1)
 * 小于target< 此时right左边的索引right-1就是我们要找的最大的索引    end = lower_bound(nums,target) - 1
 * 小于等于target<= 可以看作是找到target+1这个值的索引的左边一位，此时的索引就是target的最后出现索引    end = lower_bound(nums,target+1) - 1
 */
public class SearchRange34 {
    /**
     * 用的是左开右开的区间，二分查找最终left会在right左边
     * 如果right等于数组长度说明数组全部小于target
     * 如果left等于-1说明数组全部大于target
     * 以及nums[right]==target说明找到 反之则没找到
     * @param nums 条件数组
     * @param target 要找到的目标值
     * @return int 目标值所在的索引
     */
    public int lower_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1< right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }

    /**
     * 查找target出现的第一次和最后一次出现的索引
     * 转化成查找>=target的start和<=target+1的end索引
     * @param nums 条件数组
     * @param target 目标值
     * @return {@link int[] }
     */
    public int[] searchRange(int[] nums, int target) {
        int start = lower_bound(nums,target);
        if(start == nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }
        int end = lower_bound(nums,target+1) - 1;
        return new int[]{start,end};
    }
}
