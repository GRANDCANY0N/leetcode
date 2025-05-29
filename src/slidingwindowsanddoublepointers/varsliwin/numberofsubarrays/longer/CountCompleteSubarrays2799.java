package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.longer;

import java.util.HashMap;
import java.util.HashSet;

public class CountCompleteSubarrays2799 {
    /**
     * 先遍历数组拿到主串不同值的个数size，将hashMap清空
     * 之后第二次遍历主串，当hashMap的size等于size时说明子串此时的不同值个数等于主串
     * 移动left
     * @param nums 条件数组
     * @return int 所有子串的不同值等于主串的不同值的个数
     */
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,1);
        }
        int size = map.size();
        map.clear();
        int left = 0;
        int ans = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            while (map.size() == size) {
                int value = map.get(nums[left]);
                if (value > 1) {
                    map.put(nums[left], value - 1);
                } else {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
