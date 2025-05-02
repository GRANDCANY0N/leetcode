package hash;

import java.util.HashSet;

/**
 * @author Canyon
 */
public class ContainsDuplicate217 {
    /**
     * set计重，如果重复则满足题目条件
     * @param nums 原数组
     * @return boolean
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
