package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

/**
 * @author Canyon
 */
public class MaximumLengthSubstring3090 {
    /**
     * 用数组来维护字符的重复次数，当有字符重复次数大于2时，移动左指针
     * 从最左边开始移动，每次将每个字符的计数减1，直至触发循环条件的该字符次数不再大于2时从left到i的索引满足要求
     * @param s 条件字符串
     * @return int 最大不重复字母不超过2的子串长度
     */
    public int maximumLengthSubstring(String s) {
        char[] ch = s.toCharArray();
        int var = 2;
        int[] arr = new int[26];
        int ans = 0;int left =0;
        for (int i = 0; i < ch.length; i++) {
            int ant = ch[i] - 'a';
            arr[ant]++;
            while(arr[ant]> var){
                arr[ch[left++]-'a']--;
            }
            ans = Math.max(i- left +1,ans);
        }
        return ans;
    }
}
