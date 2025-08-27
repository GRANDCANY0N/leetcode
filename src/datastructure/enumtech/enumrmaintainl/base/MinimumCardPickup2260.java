package datastructure.enumtech.enumrmaintainl.base;

import java.util.HashMap;

/**
 * @author Canyon
 * @date 2025/08/19
 */
public class MinimumCardPickup2260 {
    /**
     * 整体思路：
     * HashMap记录每个值的出现次数，滑动窗口找到两个值相等的最小窗口
     * -
     * 步骤：
     * 用hashMap记录每个值出现的次数
     * 遍历数组，先将这个值的索引和出现次数作为key和value存入hashMap
     * 若出现次数等于两次，收缩左边的窗口直至当前值的出现次数小于两次，并更新此时窗口大小是否最小
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 滑动窗口一次遍历
     * - 空间复杂度： O(N) hashMap
     * -
     * @param cards 整数数组
     * @return int 返回值相等的最小窗口长度
     */
    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int order = 2;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int right = 0; right < cards.length; right++) {
            int card = cards[right];
            map.merge(card,1,Integer::sum);
            while(map.get(card)>=order){
                ans = Math.min(ans,right-left+1);
                map.merge(cards[left++],-1,Integer::sum);
            }
        }
        return ans!=Integer.MAX_VALUE?ans:-1;
    }

    /**
     * 整体思路：
     * hashMap存储值以及索引，每次计算索引差值之后更新相同值的索引
     * -
     * 步骤：
     * hashMap存储值以及索引
     * 遍历数组，若hashMap中未存在这个值及其索引，将值和索引存入并进行下一次循环
     * 若已存在索引，说明出现了两次相同的值，计算索引差值+1与ans比较得出最小的差值并更新索引为最新的
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 滑动窗口一次遍历
     * - 空间复杂度： O(N) hashMap
     * -
     * @param cards 整数数组
     * @return int 返回值相等的最小窗口长度
     */
    public int minimumCardPickupTwo(int[] cards) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < cards.length; i++) {
            Integer n = map.get(cards[i]);
            if(n != null) {ans = Math.min(ans,i - n + 1);}
            map.put(cards[i],i);
        }
        return ans!=Integer.MAX_VALUE?ans:-1;
    }
}
