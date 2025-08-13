package datastructure.enumtech.enumrmaintainl.base;

import java.util.HashSet;

/**
 * @author Canyon
 * @date 2025/08/13
 */
public class FindMaxK2441 {
    /**
     * 整体思路：
     * hashSet记录每个值的负值，找到当前值存在hashSet中的最大值
     * -
     * 步骤：
     * 遍历数组，将每个值的负值存于hashSet中
     * 如果当前值num存在于hashSet，则进行比较是否是最大的值
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(N) hashSet
     * @param nums 整数数组
     * @return int 返回自身与对应的负数都在数组中存在的最大正整数 k
     */
    public int findMaxK(int[] nums) {
        int ans = -1;
        HashSet<Integer> set = new HashSet<>(16);
        for (int num : nums) {
            if(set.contains(num)){
                ans = Math.max(ans,Math.abs(num));
            }else {
                set.add(~num+1);
            }
        }
        return ans;
    }
}
