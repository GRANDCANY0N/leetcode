package datastructure.enumtech.enumrmaintainl.base;

/**
 * @author Canyon
 * @date 2025/08/19
 */
public class MaxProfit121 {
    /**
     * 整体思路：
     * 对于每一天的价格，找到在它之前的最低买入价格
     * 计算今天卖出能获得的利润，和历史最大利润比较，保留最大值
     * -
     * 步骤：
     * 1. 初始化最大利润 ans = 0，最小价格 minPrice = prices[0]。
     * 2. 遍历数组 prices 中的每一个价格 price：
     *    - 用 price - minPrice 计算如果今天卖出的利润；
     *    - 与当前最大利润 ans 比较，更新 ans；
     *    - 更新 minPrice = min(minPrice, price)，保证 minPrice 始终是遇到的最小买入价。
     * 3. 遍历结束后，返回 ans。
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(1) 常数级变量
     * -
     * @param prices 整数数组
     * @return int  某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票 返回可以从这笔交易中获取的最大利润
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            ans = Math.max(price - minPrice, ans);
            minPrice = Math.min(price,minPrice);
        }
        return ans;
    }
}
