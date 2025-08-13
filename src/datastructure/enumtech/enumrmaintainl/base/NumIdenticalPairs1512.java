package datastructure.enumtech.enumrmaintainl.base;

import java.util.HashMap;

/**
 * @author Canyon
 * @date 2025/08/13
 */
public class NumIdenticalPairs1512 {
    /**
     * 整体思路：
     * hashMap记录每个数出现的次数，累计所有数出现的次数即知道最终结果
     * -
     * 步骤：
     * 遍历数组，当一个数的出现次数由n变为n+1时，数对会增加n次
     * (例如[1,1,1]->[1,1,1,1] 出现次数由3变为4，数对从3变为6)
     * 因此循环时ans先加上当前值num存于hashMap的出现次数，再将num的出现次数+1
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(N) hashMap
     * @param nums 整数数组
     * @return int 返回好数对的数目
     */
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            ans += map.getOrDefault(num,0);
            map.merge(num,1,Integer::sum);
        }
        return ans;
    }
}
