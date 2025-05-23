package slidingwindowsanddoublepointers.varsliwin.shortestorminimum;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class BalancedString1234 {
    /**
     * 统计四个字符出现的次数，当全部相等时说明已经不用替换
     * 之后维护left和right，每次遍历减去该字符出现的次数1次，当全部字符都小于1/4的长度时
     * 说明当前剩余的字符已经不满足条件，此时需要替换子串，比较替换的长度同时移动left
     * @param s 条件字符串
     * @return int 返回将原字符串替换成另一个子串以达到QWER四个字符出现次数相等的最小替换字串长度
     */
    public int balancedString(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.merge(aChar,1,Integer::sum);
        }
        int n = chars.length;
        int m = n/4;
        if(map.get('Q')==m&&map.get('W')==m&&map.get('E')==m&&map.get('R')==m){
            return 0;
        }
        int ans = n;
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            map.merge(chars[right],-1,Integer::sum);
            while(map.getOrDefault('Q',0)<=m
                    &&map.getOrDefault('W',0)<=m
                    &&map.getOrDefault('E',0)<=m
                    &&map.getOrDefault('R',0)<=m){
                ans = Math.min(ans,right-left+1);
                map.merge(chars[left++],1,Integer::sum);
            }

        }
        return ans;
    }
}
