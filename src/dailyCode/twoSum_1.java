package dailyCode;

import java.util.HashMap;

public class twoSum_1 {
    public static int[] twoSum(int[] nums, int target){
        int[] ints = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target - nums[i])){
                ints[0] = hashMap.get(target - nums[i]);
                ints[1] = i;
                return ints;
            }else {
                hashMap.put(nums[i], i);
            }
        }
        throw new RuntimeException("没有结果");
    }
}
