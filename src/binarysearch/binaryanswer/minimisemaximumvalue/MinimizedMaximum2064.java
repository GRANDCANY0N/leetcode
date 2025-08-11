package binarysearch.binaryanswer.minimisemaximumvalue;

/**
 * @author Canyon
 * @date 2025/08/11
 */
public class MinimizedMaximum2064 {
    /**
     * 整体思路：
     * 标准的二分答案求最小，对每个商店分配的商品数进行二分
     * -
     * 步骤：
     * 每个商店最小分配1，最大分配数组中的最大值
     * left设为0，right设为max(nums)
     * 本质上二分求最小，如果check返回true说明分配mid个商品可以成功，收缩右边
     * -
     * 复杂度：
     * 空间复杂度 常数级 O(1)
     * 时间复杂度 一次遍历+二分答案 O(N + NLogU) U是数组中的最大值
     * @param n 有 n 间零售商店
     * @param quantities 商品的个数数组
     * @return int
     */
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0;
        int right = 0;
        for (int quantity : quantities) {
            right = Math.max(quantity,right);
        }
        while (left + 1 < right) {
            int mid = (left+right)>>>1;
            if (check(n, quantities, mid)) {
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    /**
     * 由于每个商店只能接受同一种类商品，将每种商品除以mid向上取整
     * 如果n>=0说明可以接收，反正商店数量不够需要增大每个商店的商品数
     * @param n 有 n 间零售商店
     * @param quantities 商品的个数数组
     * @param mid 二分给定的每个商店接收的商品数
     * @return boolean 每个商店接收mid个同一种类商品，判断商店个数是否足够
     */
    public boolean check(int n, int[] quantities, int mid){
        for (int quantity : quantities) {
            n -= (quantity+mid-1)/mid;
        }
        return n>=0;
    }
}
