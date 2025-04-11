package dailyCode;

import java.util.*;
import java.util.stream.Collectors;

public class findMatrix_2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0)+1);
        }
        List<List<Integer>> result = new ArrayList<>();

        while (!hash.isEmpty()){
            List<Integer> keys = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry:hash.entrySet()){
                if(entry.getValue()>=1){
                    keys.add(entry.getKey());
                }
            }
            result.add(new ArrayList<>(keys));
            for (Integer key : keys) {
                int newValues = hash.get(key) - 1;
                if (newValues == 0) {
                    hash.remove(key);
                }else{
                    hash.put(key,newValues);
                }
            }
        }
        return result;

    }
}
