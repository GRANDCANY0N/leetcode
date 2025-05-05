package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class LengthOfLongestSubstring3 {
    /**
     * start记录左边的索引，hashMap用来判重
     * 当发生重复时，start先进行比较，如果是和start之前的字符重复则不移动，否则移动到重复字符的右边一位，因为从右边一位到当前索引i一定不重复
     * 每次循环结束比较i-start+1和ans的最大值
     * @param s 原字符串
     * @return int 最长不重复字串
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(map.containsKey(ch[i])){
                int index = map.get(ch[i]);
                if(index>=start){
                    start = index+1;
                }
            }
            map.put(ch[i],i);
            ans = Math.max(i-start+1,ans);
        }
        return ans;
    }
}
