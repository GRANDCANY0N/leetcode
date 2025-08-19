package datastructure.enumtech.enumrmaintainl.base;

import java.util.HashMap;

/**
 * @author Canyon
 * @date 2025/08/19
 */
public class MinimumCardPickup2260 {
    /**
     * 整体思路：
     * -
     * 步骤：
     * -
     * 复杂度：
     * - 时间复杂度： O()
     * - 空间复杂度： O()
     * -
     * @param cards
     * @return int
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
     * -
     * 步骤：
     * -
     * 复杂度：
     * - 时间复杂度： O()
     * - 空间复杂度： O()
     * -
     * @param cards
     * @return int
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
