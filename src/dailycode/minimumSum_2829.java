package dailyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class minimumSum_2829 {
    public int minimumSum(int n, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            map.put(k-i, i);
            if(map.containsKey(i)){
                n++;
                continue;
            }
            sum +=i;
        }
        return sum;
    }
}
