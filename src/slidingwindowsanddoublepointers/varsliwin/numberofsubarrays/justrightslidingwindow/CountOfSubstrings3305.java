package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.justrightslidingwindow;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class CountOfSubstrings3305 {
    public long countOfSubstrings(String word, int k) {
        return atLeastSlidingWindow(word,k) - atLeastSlidingWindow(word,k+1);
    }

    /**
     * 恰好型滑动窗口转换成两个至少型的滑动窗口，用至少k个窗口减去至少k+1个窗口得出恰好的个数
     * @param word 原字符串
     * @param k 恰好的辅音字符个数
     * @return long
     */
    public long atLeastSlidingWindow(String word, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        long ans = 0;int left = 0;
        //维护辅音字母个数
        long cnt = 0;
        char[] ch = word.toCharArray();
        for (char c : ch) {
            if ("aeiou".indexOf(c) >= 0) {
                map.merge(c, 1, Integer::sum);
            } else {
                cnt++;
            }
            while (map.size()==5 && cnt >= k) {
                char w = ch[left];
                if("aeiou".indexOf(w)>=0){
                    if(map.merge(w,-1,Integer::sum)==0){
                        map.remove(w);
                    }
                }else {
                    cnt--;
                }
                left++;
            }
            ans+=left;
        }
        return ans;
    }
}
