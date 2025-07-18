package binarysearch.search.helper;

public class BinarySearchHelper {
    /**
     * 开区间二分，所得到必须是有效索引
     * 为什么是返回right？因为是从右边收缩，当nums[mid] >= target时将right收缩至mid
     * 本身就是找大于等于目标值的最小索引，只要收缩过一次就说明至少存在这样的索引，只需要再往左边继续有没有更小的符合要求的值即可
     * @param nums 给定数组
     * @param target 给定目标值
     * @return int 返回数组中大于等于目标值的最小索引
     */
    public int lower_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left+1 < right) {
            int mid = (right + left)>>>1;
            if(nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
