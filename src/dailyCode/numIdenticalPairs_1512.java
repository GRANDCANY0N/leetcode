package dailyCode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class numIdenticalPairs_1512 {
    public static int numIdenticalPairs(int[] nums) {
        if (nums.length == 0 ||nums.length ==1 ){
            return 0;
        }
        int goodNum = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0)+1);
        }
        Collection<Integer> va =  hash.values();
        for (Integer integer : va) {
            goodNum += jieC(integer-1);
        }
        return goodNum;
    }
    public static int jieC(int a){
        if (a == 1) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        return a+(jieC(a-1));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
    }
}
