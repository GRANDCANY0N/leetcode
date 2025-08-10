package binarysearch.binaryanswer.binaryindirectvalue;

import java.util.Arrays;

public class MaxProfit1648 {
    /**
     * 自定义的范围(left,right]在nums二分
     * @param nums 球的库存
     * @param target 目标值
     * @param left 索引范围左
     * @param right 索引范围右
     * @return int 返回target在当前数组中的索引
     */
    public int upperBound(int[] nums, int target, int left, int right) {
        while(left+1<right) {
            int mid = (left+right)>>1;
            if(nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }

    /**
     * 计算等差数列的和
     * rightVal 递减到 leftVal（包含）的连续 nums 个数的总和
     *
     * @param rightVal 等差数列的最大值
     * @param nums     项数
     * @return 等差数列求和结果
     */
    public long sum(int rightVal, int nums) {
        return ((long) (rightVal-nums+1 + rightVal) * nums)/2;
    }

    /**
     * 最大利润计算
     *  -
     * 贪心策略：
     *  先卖价值最高的球（库存数组最大值）
     *  将该价值的球一批一批降价到次高价值
     *  每次操作尽可能卖出更多高价值球，直到 orders 售完
     *  -
     *  步骤：
     *  排序库存数组，方便找到当前最大值和次大值
     *  设 target 为当前最大值，找到库存中比它小的下一个值（用 upperBound）
     *  考虑两种情况，从最大值降到次大值的组数(例如[1,2,2],组数为2,有两组需要降到1)和从最大值降到次大值的大小(例如[1,2,2],从2降到1需要售出1)
     *  1、组数*大小 < orders,该区间可以卖完，继续处理下一个最大值
     *  2、组数*大小 >= orders，需要分批处理：
     *     - 先将每组球的价值从 target 依次降 group 级（group = orders / 组数），
     *       这部分可以直接用等差数列求和计算总价值；
     *     - 剩余的 remainder = orders % 组数 个球仍保持在 target - group 的价值，
     *       将它们单独计算利润；
     *     - 此时 orders 用完，终止循环。
     *  直至orders降为0
     *  -
     *  复杂度：
     *  空间复杂度    常量级，O(1)
     *  时间复杂度    排序+二分，O(NLogN+NLogN)
     * @param inventory 球的库存数组
     * @param orders 要减少的球的个数
     * @return int 返回卖了 orders 个球以后 最大 总价值之和，对 1e9 + 7 取余数

     */
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long value = 0;
        int mod = 1000000007;
        int left = -1;
        int right = inventory.length;
        int target = inventory[right-1];
        while (orders > 0) {
            int startIndex = upperBound(inventory, target, left, right)-1;
            int leftVal = startIndex<0?0:inventory[startIndex];
            int d = target-leftVal;
            int a = inventory.length - startIndex - 1;
            if(orders<=(long)a*d){
                int group = orders/a;
                int remainder = orders%a;
                value = (value+a*sum(target,group)+ (long) remainder *(target-group))%mod;
                break;
            }else {
                value = (value+a*sum(target,d))%mod;
                orders -= a*d;
            }
            target = inventory[startIndex];
            right = startIndex;
        }
        return (int) (value%mod);
    }

    public static void main(String[] args) {
        int[] inventory = {1000000000,1000000000,1000000000};
        System.out.println(new MaxProfit1648().maxProfit(inventory, 1000000000));
    }
}
