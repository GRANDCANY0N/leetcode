package binarysearch.search.helper;

public class BinarySearchHelper {
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
