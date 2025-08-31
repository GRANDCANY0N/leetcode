package datastructure.enumtech.enumrmaintainl.base;

import java.util.HashMap;


/**
 * @author canyon
 * @date 2025/08/31
 */
public class CountTrapezoids3623 {
    /**
     * 整体思路：
     * 统计每条线上可以组成平行线的个数，根据数学公式计算答案
     * -
     * 步骤：
     * hashMap的key和value是y轴坐标和对应的点的个数
     * 基于点的个数，先计算两两组合的个数
     * 再依次计算当前个数和累计个数的乘积，之后更新累计个数
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(N) hashMap
     * -
     * @param points 二维整数数组
     * @return int 水平平行边的个数 对1e9+7取余
     */
    public int countTrapezoids(int[][] points) {
        int mod = (int)1e9+7;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int[] point : points) {
            map.merge(point[1], 1, Integer::sum);
        }
        long ans = 0; long side = 0;
        for (Integer value : map.values()) {
            long c = ((long) (value - 1) *value/2);
            ans += side*c%mod;
            side += c;
        }
        return (int) (ans%mod);
    }
}
