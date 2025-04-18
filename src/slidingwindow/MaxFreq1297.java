package slidingwindow;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class MaxFreq1297 {
    /**
     *
     * @param s 原字符串
     * @param maxLetters 不重复值的最大数
     * @param minSize 字串的最小长度
     * @param maxSize 字串的最大长度，但是没用上，当最小的长度满足条件时，即使再加上后续字符满足最长字串，最后结果也只会少不会多
     * @return 满足字串>=最小长度且不超过指定maxLetters的最多字串出现次数
     */
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        HashMap<String, Integer> strMap = new HashMap<>();
        int ans = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            charMap.put(ch[i],charMap.getOrDefault(ch[i],0)+1);
            if(i<minSize-1){
                continue;
            }
            if(charMap.size()<=maxLetters){
                String str = s.substring(i-minSize+1,i+1);
                strMap.put(str,strMap.getOrDefault(str,0)+1);
                int value = strMap.get(str);
                ans = Math.max(value,ans);
            }
            int left = i-minSize+1;
            int va = charMap.get(ch[left])-1;
            if(va < 1){
                charMap.remove(ch[left]);
            }else {
                charMap.put(ch[left],va);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabcabcab";
        int i = new MaxFreq1297().maxFreq(s, 2, 2, 3);
        System.out.println(i);
    }
}
