package dailycode;

/**
 * @author canyon
 * @date 2025/07/02
 */
public class PossibleStringCount3330 {
    /**
     * 仅需判断前一个字符是否和后一个一样，一样则说明重复，ans可以加一次
     * @param word 字符串
     * @return int 允许减少一个连续重复字符的子串个数（包括初始字符串）
     */
    public int possibleStringCount(String word) {
        int ans = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }
}
