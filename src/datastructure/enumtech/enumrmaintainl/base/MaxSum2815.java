package datastructure.enumtech.enumrmaintainl.base;

/**
 * @author Canyon
 * @date 2025/08/23
 */
public class MaxSum2815 {
    /**
     * 整体思路：
     * 计算每个数位上的最大的两个值的和，最后进行比较返回最大值
     * -
     * 步骤：
     * 开辟一个长度为10的一维数组，存储0-9每个数位上的最大值
     * 遍历数组，计算当前值数位的最大值进行归类
     * 判断当前值的最大数位在一维数组中是否存在，不存在则替换
     * 存在则将当前值加上数组中的值并于ans比较取最大值，并且将当前值与一维数组中的值进行比较取最大值留在数组中
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(1) 常数级变量
     * -
     * @param nums 整数数组
     * @return int 从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等
     */
    public int maxSum(int[] nums) {
        int ans = -1;
        int[] arr = new int[10];
        for (int num : nums) {
            int n = maxPos(num);
            if (arr[n] == 0) {
                arr[n] = num;
            } else {
                ans = Math.max(ans, num + arr[n]);
                arr[n] = Math.max(arr[n], num);
            }
        }
        return ans;
    }

    /**
     * 循环取余
     * @param num 给定数
     * @return int 返回给定num的数位上的最大值
     */
    public int maxPos(int num){
        int max = 0;
        while(num!=0){
            max = Math.max(num%10,max);
            num /= 10;
        }
        return max;
    }
}
