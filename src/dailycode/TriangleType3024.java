package dailycode;

import java.util.HashSet;

/**
 * @author Canyon
 */
public class TriangleType3024 {
    public String triangleType(int[] nums) {
        int sum=0;int max=0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            sum+=num;
            max = Math.max(max,num);
        }
        int size = set.size();
        if(sum <= 2*max){
            return "none";
        }
        if(size==1){
            return "equilateral";
        }
        if(size==2){
            return "isosceles";
        }
        return "scalene";
    }
}
