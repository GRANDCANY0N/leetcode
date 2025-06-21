package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

/**
 * @author canyon
 * @date 2025/06/21
 */
public class CountFairPairs2563  {
    /**
     * 二分变种，函数定义right
     */
    public int lowerBound(int[] nums,int right, int target) {
        int left = -1;
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

    /**
     * 先对数组排序
     * 判断nums[i] + nums[i+1]是否大于upper 大于说明之后都不存在这样的数
     * 之后将大于等于lower - nums[i] 和 小于upper-nums[i]作为target进行二分查找
     * 时间复杂度(3nlogN)
     * @param nums 数字数组
     * @param lower nums[i]+nums[j]的最小值
     * @param upper nums[i]+nums[j]的最大值
     * @return long 满足lower <= nums[i] + nums[j] <= upper的个数
     *
     * 方法二：
     * 先排序
     * 二分的数组范围是每个值的0到i的索引
     * 当前面相邻两个值相加小于lower可以直接continue此次循环
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i<nums.length-1&&nums[i]+nums[i+1]<lower){
                continue;
            }
            int start = lowerBound(nums,i,lower-nums[i]);
            int end = lowerBound(nums,i,upper-nums[i]+1);
            ans += end - start;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,7,4,4,5};
        System.out.println(new CountFairPairs2563().countFairPairs(nums, 3, 6));
    }
}
