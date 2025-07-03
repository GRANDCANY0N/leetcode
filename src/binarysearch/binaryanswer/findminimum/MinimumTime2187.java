package binarysearch.binaryanswer.findminimum;

/**
 * @author Canyon
 * @date 2025/07/03
 */
public class MinimumTime2187 {

    /**
     * sum用来维护在时间为mid的情况下，所有车次能完成的旅途次数之和
     * @param times 时间数组
     * @param mid (left,right]的中间值
     * @param totalTrips 门槛值
     * @return boolean
     */
    public boolean check(int[] times, long mid, int totalTrips){
        long sum = 0;
        for (int time : times) {
            sum += mid / time;
            if(sum>=totalTrips){
                return true;
            }
        }
        return false;
    }
    /**
     * 首先是构造left和right的二分数组，left=0，为什么right是时间数组中最小的值*totalTrips，因为这个乘积一定会满足totalTrips
     * 之后对(left,right]进行二分，调用check函数，返回true说明此时已经满足totalTrips，right=mid，反之left=mid
     * @param time 时间数组 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间
     * @param totalTrips 旅途次数
     * @return long 满足旅途次数的最小时间
     */
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        for (int i : time) {
            right = Math.min(i,right);
        }
        right *= totalTrips;
        while(left+1<right){
            long mid = (left+right)>>>1;
            if(check(time,mid,totalTrips)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }
}
