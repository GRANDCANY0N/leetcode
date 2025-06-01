package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.shorter;

public class CountKConstraintSubstrings3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0, count = 0;
        char[] ch = s.toCharArray();
        int[] cnt = new int[2];
        for (int right = 0; right < ch.length; right++) {
            cnt[ch[right] - '0']++;
            while(cnt[0]>k&&cnt[1]>k){
                cnt[ch[left++]-'0']--;
            }
            count += right - left + 1;
        }
        return count;
    }
}
