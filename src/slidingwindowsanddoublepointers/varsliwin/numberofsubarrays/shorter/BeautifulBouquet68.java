package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.shorter;

import java.util.HashMap;

public class BeautifulBouquet68 {
    /**
     * 用hashMap维护不同种类花出现的次数。当某一种花的个数超过cnt时移动left
     * @param flowers 条件数组
     * @param cnt 同类别的花的个数
     * @return int 所有子串中同类别的花的个数不超过cnt的子串个数
     */
    public int beautifulBouquet(int[] flowers, int cnt) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int right = 0; right < flowers.length; right++) {
            map.merge(flowers[right],1,Integer::sum);
            while (map.get(flowers[right]) > cnt) {
                int val = map.get(flowers[left]);
                if(val>1){
                    map.put(flowers[left], val - 1);
                }else {
                    map.remove(flowers[left]);
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans % 1000000007;
    }
}
