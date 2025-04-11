package dailyCode;

import java.util.Collection;
import java.util.HashMap;

public class largestVariance_2272 {
    public int largestVariance(String s) {
        int output = 0;

        for (int step = 2; step < s.length() + 1 ; step++) {
            for (int start = 0; start < s.length()-step+1; start++) {
                int waveLen = wave(s.substring(start, start+step));
                if(output <= waveLen){
                    output = waveLen;
                }
            }

        }

        return output;
    }


    public static int wave(String s){
        HashMap<Character,Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
//            hash.put(s.charAt(i),hash.getOrDefault(hash.get(s.charAt(i)), 0)+1);
            if(hash.containsKey(s.charAt(i))){
                hash.replace(s.charAt(i),hash.get(s.charAt(i))+1);
            }else {
                hash.put(s.charAt(i),1);
            }
        }
        Collection<Integer> va =  hash.values();
        int min = va.stream().mapToInt(Integer::intValue).min().orElse(1);
        int max = va.stream().mapToInt(Integer::intValue).max().orElse(1);
        return max - min;
    }
}
