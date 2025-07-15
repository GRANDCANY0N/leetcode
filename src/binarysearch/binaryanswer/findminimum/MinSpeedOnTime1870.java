package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/15
 */
public class MinSpeedOnTime1870 {
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
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<=dist.length-1){
            return -1;
        }
        int left = 0;
        int right = 0;
        for (int dis : dist) {
            right = Math.max(right, dis);
        }
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
