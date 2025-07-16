package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/15
 */
public class MinSpeedOnTime1870 {
    /**
     * sum维护给定速度mid下的花费时间
     * 除了最后一辆车，其他车都需要准点上，因此只在最后一辆车考虑double，其他车都只需要向上取整
     * sum>=hour说明时间不够，返回false
     * 否则返回true
     * @param dist 每趟列车的行驶距离
     * @param mid 二分给定的速度
     * @param hour 到达办公室可用的总通勤时间
     * @return boolean 时限前到达办公室所要求全部列车的 最小正整数 时速，无法到达返回-1
     */
    public boolean check(int[] dist,int mid, double hour){
        double sum = 0;
        for (int i = 0; i < dist.length; i++) {
            if(i==dist.length-1){
                sum += (double) dist[i] /mid;
            }else {
                sum += (dist[i]+mid-1)/mid;
            }
            if(sum>=hour){
                return false;
            }
        }
        return true;
    }

    /**
     * 由于必须整点上列车，当列车的次数-1还大于等于给定时间hour则说明速度再快也无法完成，返回-1
     * 剩下的由于hour是小数点后两位，dist的最大值*100作为right
     * @param dist 列车的行驶距离
     * @param hour 到达办公室可用的总通勤时间
     * @return int 时限前到达办公室所要求全部列车的 最小正整数 时速
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<=dist.length-1){
            return -1;
        }
        int left = 0;
        int right = 0;
        for (int dis : dist) {
            right = Math.max(right, dis);
        }
        right *= 100;
        while (left+1 < right) {
            int mid = (left + right)>>1;
            if(check(dist,mid,hour)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }
}
