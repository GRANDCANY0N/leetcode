package binarysearch.binaryanswer.minimisemaximumvalue;

/**
 * @author Canyon
 * @date 2025/08/11
 */
public class SplitArray410 {
    /**
     * group维护子数组的个数，sum维护每个子数组的和，maxSum维护子数组的和中最大值
     * 当sum + num > mid，更新子数组分组，并且比较出子数组中的最大值
     * 循环结束需要补充比较maxSum与最后一个子数组的和中的最大值
     * @param nums 整数数组
     * @param k 将这个数组分成 k 个非空的连续子数组
     * @param mid 二分给定的每个子数组的和的范围
     * @return boolean 判断每个子数组的和不超过mid前提下子数组的个数也不超过k
     */
    public boolean check(int[] nums, int k, int mid){
        int group = 1;
        int sum = 0;
        int maxSum = 0;
        for (int num : nums) {
            if (sum + num > mid) {
                maxSum = Math.max(maxSum, sum);
                sum = 0;
                group++;
            }
            sum += num;
        }
        maxSum = Math.max(maxSum, sum);
        return maxSum<=mid && group<=k;

    }

    /**
     * 整体思路：
     * 对每个子数组的和的最大值进行二分
     * -
     * 步骤：
     * 确认二分范围，最小的子数组和是数组中的最大值，最大的子数组和是数组的和
     * left设为max(nums)-1,right设为sum(nums)
     * 找最小的最大值本质上是找最小值，check函数满足将收缩右边窗口
     * -
     * 复杂度：
     * 空间复杂度 常数级 O(1)
     * 时间复杂度 一次遍历+二分答案 O(N + NLogU) U是数组中的最大值和数组和的差
     * @param nums 整数数组
     * @param k 将这个数组分成 k 个非空的连续子数组
     * @return int 使k个子数组各自和最小，返回其中的最大值
     */
    public int splitArray(int[] nums, int k) {
        int right = 0;
        int left = 0;
        for (int num : nums) {
            left = Math.max(num,left)-1;
            right += num;
        }
        while(left+1<right){
            int mid = (left+right)>>>1;
            if(check(nums,k,mid)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums= {1,4,4};
        System.out.println(new SplitArray410().splitArray(nums,3));
    }
}
