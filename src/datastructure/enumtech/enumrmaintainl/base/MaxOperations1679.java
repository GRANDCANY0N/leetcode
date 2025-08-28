package datastructure.enumtech.enumrmaintainl.base;

import java.util.HashMap;

/**
 * @author canyon
 * @date 2025/08/28
 */
public class MaxOperations1679 {
    /**
     * 整体思路：
     * 每次先看看哈希表中是否有 k−nums[i]，有就去掉哈希表中的一个 k−nums[i]，同时把答案加一，没有就把 nums[i] 加入哈希表
     * -
     * 步骤：
     * hashMap存储以每次遍历的值和k的差值做key，出现次数做value
     * 每次当前值与hashMap的key对上就说明有一对，使当前key的value-1
     * 否则就将k-num作为key存入hashMap
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(N) hashMap
     * -
     * @param nums 整数数组
     * @param k 选出和为 k 的两个整数
     * @return int 返回最大移除和为 k 的两个整数的操作次数
     */
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if(num>=k) continue;
            int count = map.getOrDefault(num, 0);
            if(count>0){
                ans++;
                map.put(num, count-1);
            }else {
                map.merge(k-num, 1, Integer::sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,1,2,1,2,2,2,2};
        System.out.println(new MaxOperations1679().maxOperations(nums, 3));
    }
}
