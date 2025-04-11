package dailyCode;

import java.util.HashMap;

public class minimumOperations_3396 {
    public int minimumOperations(int[] nums) {
        int operationNums = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        int i=0;
        while(i<nums.length){
            int k = i;
            while(map.containsKey(nums[i])){
                for (int j = 0; j < 3; j++) {
                    if(index<nums.length){
                        map.remove(nums[index]);
                        index++;
                    }
                }
                operationNums++;
                if(index==nums.length){
                    return operationNums;
                }
                if(i<index){
                    k = index;
                }
            }
            i = k;
            map.put(nums[k],map.getOrDefault(nums[k],0)+1);
            i++;
        }
        return operationNums;
    }

    public static void main(String[] args) {
        minimumOperations_3396 minimumOperations3396 = new minimumOperations_3396();
        int[] arr = {4,14,4,4};
        System.out.println(minimumOperations3396.minimumOperations(arr));
    }
}
