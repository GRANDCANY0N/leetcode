package dailyCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class longestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        int lens = nums.length;
        if(lens == 1 || lens ==0){
            return lens;
        }
        int currentSteak = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer x : set) {
            if(set.contains(x-1)){
                continue;
            }
            int y = x+1;
            while (set.contains(y)){
                y++;
            }
            currentSteak = Math.max(currentSteak,y-x);
        }
        return currentSteak;

    }
}
