package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.justrightslidingwindow;

import java.util.HashMap;

/**
 * @author Canyon
 * @date 2025/07/29
 */
public class CountOfSubstrings3306 {
    public long countOfSubstrings(String word, int k) {
        return solution(word,k) - solution(word,k+1);
    }
    public long solution(String word, int k) {
        char[] chars = word.toCharArray();
        long ans = 0;
        int left = 0;
        long sum = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if ("aeiou".indexOf(aChar) >= 0) {
                map.merge(aChar, 1, Integer::sum);
            }else {
                sum += 1;
            }
            while (map.size()==5 && sum >= k) {
                if ("aeiou".indexOf(chars[left]) >= 0) {
                    int value = map.get(chars[left]);
                    if(value>1){
                        map.put(chars[left],value-1);
                    }else {
                        map.remove(chars[left]);
                    }
                }else {
                    sum -=1;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }


}
