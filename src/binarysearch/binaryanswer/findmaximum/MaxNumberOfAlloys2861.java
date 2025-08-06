package binarysearch.binaryanswer.findmaximum;

import java.util.Collections;
import java.util.List;

/**
 * @author Canyon
 * @date 2025/08/01
 */
public class MaxNumberOfAlloys2861 {
    /**
     * 最坏情况一个都无法生产，最好情况是生产一个只需1，加之stock的短板效应，最多生产budget+min(stock)个合金
     * 范围划定[0,min(stock)+budget]
     * left设为0，right设为min(stock)+budget+1
     * @param n 每个合金需要的材料种类数目
     * @param k 机器数
     * @param budget 预算
     * @param composition 包含每台机器生产合金需要的材料数量
     * @param stock 初始库存
     * @param cost 每个材料购买所需的费用
     * @return int 在budget下能生产的最大合金数
     */
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int left = 0;
        int right = Collections.min(stock) + budget+1;
        Integer[] stock1 = stock.toArray(Integer[]::new);
        Integer[] cost1 = cost.toArray(Integer[]::new);
        while(left+1<right){
            int mid = (right+left)>>>1;
            if(check(budget,composition,stock1,cost1,mid)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 计算每台机器生产mid个合金的费用money
     * 如果stock[i]本身库存能完全覆盖某个材料生产mid个合金,也就是stock[i]>= list[i]，此时这个类别的材料就不需要购买
     * 否则就需要购买(list[i]-stock[i])个材料，花费(list[i]-stock[i])*cost[i]
     * 最后价格如果小于等于budget，说明满足生产，返回true，否则不满足，返回false
     * @param budget 预算
     * @param composition 包含每台机器生产合金需要的材料数量
     * @param stock 初始库存
     * @param cost 每个材料购买所需的费用
     * @param mid 二分给定的合金数
     * @return boolean 判断在budget下能否生产mid数量的合金
     */
    public boolean check(int budget, List<List<Integer>> composition, Integer[] stock, Integer[] cost,int mid){
        for (List<Integer> list : composition) {
            Integer[] comp = list.toArray(Integer[]::new);
            long money = 0;
            for (int i = 0; i < comp.length && money <= budget; i++) {
                if (stock[i] < (long) comp[i] * mid) {
                    money += ((long) comp[i] * mid - stock[i]) * cost[i];
                }
            }
            if(money<=budget){
                return true;
            }
        }
        return false;
    }
}
