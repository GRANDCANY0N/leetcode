package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

/**
 * @author Canyon
 */
public class LongestSemiRepetitiveSubstring2730 {
    /**
     * cnt记录连续两个字符重复的次数，超过1时移动left，当left和left+1索引所在的字符相同时cnt减1，
     * 此时子串中只有一个连续重复的字符
     * @param s 条件字符串
     * @return int 半重复子串的最大长度
     */
    public int longestSemiRepetitiveSubstring(String s) {
        char[] ch = s.toCharArray();
        int left=0;int ans=1;int cnt=0;
        for (int right = 1; right < ch.length; right++) {
            if(ch[right]==ch[right-1]){
                cnt++;
            }
            while(cnt>1){
                if(ch[left]==ch[left+1]){
                    cnt--;
                }
                left++;
            }
            ans = Math.max(right-left+1,ans);
        }
        return ans;
    }
}
