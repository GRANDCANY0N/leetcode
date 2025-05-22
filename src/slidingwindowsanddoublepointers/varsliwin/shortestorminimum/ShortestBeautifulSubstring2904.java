package slidingwindowsanddoublepointers.varsliwin.shortestorminimum;

/**
 * @author Canyon
 */
public class ShortestBeautifulSubstring2904 {
    /**
     * left维护左边，当子串中1的个数满足k时，移动left，并计算该字串的长度与之前的子串长度比较
     * 比之前的子串长度小则进行替换，如果长度相同则进行比较
     * 每次比较相同位置的两个字符，如果str的字符大于当前子串的字符，则进行替换
     * @param s 条件字符串
     * @param k 子串中1的个数
     * @return {@link String } 满足长度最小的且字典值最小的子串
     */
    public String shortestBeautifulSubstring(String s, int k) {
        int lens = s.length();int left=0;
        String str = "";
        char[] chars = s.toCharArray();
        int[] cnt = new int[2];
        for (int i = 0; i < chars.length; i++) {
            cnt[chars[i]-'0']++;
            while(cnt[1]>=k){
                cnt[chars[left]-'0']--;
                int ans = i - left;
                if(ans < lens){
                    lens = ans;
                    str = s.substring(left,i+1);
                }else if(ans==lens){
                    int index=left;
                    for (int i1 = 0; i1 < str.length(); i1++) {
                        if(chars[index]<str.charAt(i1)){
                            str = s.substring(left,i+1);
                            break;
                        }else if(chars[index]>str.charAt(i1)){
                            break;
                        }
                        index++;
                    }
                }
                left++;
            }
        }
        return str;
    }


}
