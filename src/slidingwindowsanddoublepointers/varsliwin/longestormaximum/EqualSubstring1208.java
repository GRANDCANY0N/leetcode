package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

/**
 * @author Canyon
 */
public class EqualSubstring1208 {
    /**
     * 当maxCost<0时说明此时的变更字符串长度超出预算，需要进行滑窗
     * @param s 条件字符串
     * @param t 条件字符串
     * @param maxCost 变更字符串的最大预算
     * @return int 可以转化的最大长度
     */
    public int equalSubstring(String s, String t, int maxCost) {

        int ans = 0;int left = 0;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            maxCost -= Math.abs(ch1[i]-ch2[i]);
            while(maxCost<0){
                maxCost += Math.abs(ch1[left]-ch2[left]);
                left++;
            }
            ans = Math.max(ans,i-left+1);
        }
        return ans;
    }

}
