package datastructure.enumtech.enumrmaintainl.base;

/**
 * @author Canyon
 * @date 2025/08/27
 */
public class MaximumSum2342 {
    /**
     * 整体思路：
     * 题目限制数小于1e9，开辟一个长度为82的数组用于存储数位和的数
     * 更新数位和相同的数以及最大值
     * -
     * 步骤：
     * 开辟一个长度为82的数组用于存储数位和的数
     * 遍历数组，循环取余求出当前数的数位和
     * 若一维数组中在当前数位和索引下存在数，将ans与这两数之和比较取最大值，并更新当前数位和索引中的数为这两个数的较大值
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(1) 常数级变量
     * -
     * @param nums 正整数数组
     * @return int 返回nums中数位和相同的两个数的最大值
     */
    public int maximumSum(int[] nums) {
        int ans = -1;
        int[] arr = new int[82];
        for (int num : nums) {
            int sum = sumNum(num);
            if(arr[sum]>0){
                ans = Math.max(ans,arr[sum]+num);
            }
            arr[sum] = Math.max(arr[sum],num);
        }
        return ans;
    }

    /**
     * 循环取余
     * @param num 整数
     * @return int 返回整数的数位和
     */
    public int sumNum(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
