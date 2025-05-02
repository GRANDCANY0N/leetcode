package hash;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class ContainsNearbyDuplicate219 {
    /**
     * hashMap的key存值，value存索引，相同值判断当前索引的和value的差是否满足要求
     * @param nums 条件数组
     * @param k 要求数组中值相等的同时且索引差的绝对值小于k
     * @return boolean
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i]) && (i - hashMap.get(nums[i])) <= k){
                return true;
            }
            hashMap.put(nums[i],i);
        }
        return false;
    }
}
