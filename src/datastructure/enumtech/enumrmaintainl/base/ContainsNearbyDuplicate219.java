package datastructure.enumtech.enumrmaintainl.base;


import java.util.HashMap;

/**
 * @author Canyon
 * @date 2025/08/19
 */
public class ContainsNearbyDuplicate219 {
    /**
     * 整体思路：
     * 记录下每个值和索引，判断值相同的索引是否小于等于k即可
     * -
     * 步骤：
     * 遍历数组，hashMap记录此次值和索引
     * 若此次值已存在hashMap中并且索引差小于等于k则说明满足题意
     * 否则就将此次值的索引替换原来的索引，因为循环遍历相同值的索引差只会越来越大
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(N) hashMap
     * -
     * @param nums 整数数组
     * @param k 整数
     * @return boolean  判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])&&i-map.get(nums[i])<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
