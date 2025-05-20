package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

/**
 * @author Canyon
 */
public class TakeCharacters2516 {
    /**
     * 第一次遍历获取abc三个字符的总数，并判断是否都满足k个要求，不满足直接返回-1
     * 第二个转换思路，改为取走最多的不会影响结果的子串
     * 当拿走最长的子串之后，剩下的就是最短的满足要求的长度
     * @param s 条件字符串
     * @param k abc三个字符至少要满足k个
     * @return int 从 最左侧或最右侧取走字符，满足abc都满足k个的最小 字符串数
     */
    public int takeCharacters(String s, int k) {
        char[] chars = s.toCharArray();
        //ints存储a b c出现的次数
        int[] ints = new int[3];
        for (char aChar : chars) {
            ints[aChar - 'a']++;
            if(ints[0]<k || ints[1]<k || ints[2]<k){
                return -1;
            }
        }
        int ans = 0;int left=0;
        for (int right = 0; right < chars.length; right++) {
            int c = chars[right]-'a';
            ints[c]--;
            while(ints[c]<k){
                ints[chars[left]-'a']++;
                left++;
            }
            ans = Math.max(right-left+1,ans);
        }
        return s.length()-ans;
    }
}
