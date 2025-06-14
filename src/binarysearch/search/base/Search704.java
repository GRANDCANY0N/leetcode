package binarysearch.search.base;

import binarysearch.search.helper.BinarySearchHelper;

public class Search704 {
    public int lower_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while(left+1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
    /**
     * 大于等于target 类型
     * @param nums 条件升序数组
     * @param target 目标值
     * @return int 目标值的索引 没有返回-1
     */
    public int search(int[] nums, int target) {
        BinarySearchHelper binarySearchHelper = new BinarySearchHelper();
        int start = binarySearchHelper.lower_bound(nums,target);
        if(start == nums.length || nums[start] != target){return -1;}
        return start;
    }
}
