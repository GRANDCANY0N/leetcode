package dailycode;

/**
 * @author Canyon
 */
public class ThreeConsecutiveOdds1550 {
    /**
     * 判断数组中是否存在连续三个奇数，用cnt来计数，如果是偶数则重新cnt=0
     * @param arr 条件数组
     * @return boolean
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int i : arr) {
            if(i%2==0){
                cnt=0;
                continue;
            }else {
                cnt++;
            }
            if(cnt>=3){
                return true;
            }
        }
        return false;
    }
}
