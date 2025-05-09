package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class TotalFruit904 {
    /**
     * 用hashMap来维护水果种类，当map的size大于2时说明有3类水果，从left开始遍历直至移除一种水果
     * @param fruits 条件数组
     * @return int 水果种类不超过2的最长字串
     */
    public int totalFruit(int[] fruits) {
        int ans = 0;int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>(2);
        for (int i=0;i<fruits.length;i++) {
            map.merge(fruits[i],1,Integer::sum);
            while (map.size()>2){
                int index = fruits[left++];
                int value = map.get(index)-1;
                if(value>0){
                    map.put(index,value);
                }else {
                    map.remove(index);
                }
            }
            ans = Math.max(i-left+1,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]  arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new TotalFruit904().totalFruit(arr));
    }
}
