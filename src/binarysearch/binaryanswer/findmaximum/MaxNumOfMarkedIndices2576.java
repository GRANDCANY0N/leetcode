package binarysearch.binaryanswer.findmaximum;

import java.util.Arrays;

/**
 * @author Canyon
 * @date 2025/07/30
 */
public class MaxNumOfMarkedIndices2576 {
    /**
     * 由于需要两两配队，左闭右开情况下，将nums排序
     * left设为最少的配对数0，right设为最多的配队数+1，最多就是nums.length/2+1
     * @param nums 整数数组
     * @return int 满足 2 * nums[i] <= nums[j]的最多下标
     */
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = (nums.length)/2+1;
        while(left+1<right){
            int mid = (left+right)>>1;
            if(check(mid,nums)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left*2;
    }

    /**
     * 在顺序数组下，只需要考虑[0,mid)和[nums.length-mid,nums.length)的索引是否匹配
     * 因此一旦出现nums[i]*2 > nums[nums.length-mid+i]则返回false，否则全部符合则返回true
     * @param mid 二分给定的配对数
     * @param nums 整数数组
     * @return boolean 判断是否有mid对符合条件
     */
    public boolean check(int mid, int[] nums){
        for (int i = 0; i < mid; i++) {
            if(nums[i]*2 > nums[nums.length-mid+i]){
                return false;
            }
        }
        return true;
    }
}
