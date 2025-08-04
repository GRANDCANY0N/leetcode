package binarysearch.binaryanswer.findmaximum;

/**
 * 看题解 hard
 * @author Canyon
 * @date 2025/08/04
 */
public class MaxRunTime2141 {
    /**
     * 首先考虑使用二分，最好情况是每个电池使用时间都相同且电池数量能整除电脑数
     * 此时的运行时间为`sum(batteries)/n`，最坏情况是电池数小于电脑数，无法满足所有电脑同时充电
     * 范围是`[0,sum(batteries)/n]`，left设为0，right设为sum/n+1
     * @param n 电脑数
     * @param batteries 电池数组
     * @return long 让 n 台电脑同时运行的 最长 分钟数
     */
    public long maxRunTime(int n, int[] batteries) {
        long left = 0;
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        long right = sum/n+1;
        while (left + 1 < right) {
            long mid = (left+right)>>1;
            if(check(mid,batteries,n)){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }

    /**
     * 对于给定时间`p`，将所有的电池进行分类
     * 对于大于等于`p`的电池，使用`p`分钟填满一列矩阵，剩余的舍弃，因为同一行不能出现相同颜色的电池
     * 对于小于`p`的电池，只需要考虑小于`p`的电池和是否足够填充剩下的矩阵，因为本身不满足填满一整列，不会出现同一行出现相同颜色的情况
     * @param mid 二分给定的运行时间
     * @param n 电脑数
     * @param batteries 电池数组
     * @return boolean 判断是否n和batteries能否满足二分给定的运行时间mid
     */
    public boolean check(long mid, int[] batteries, int n){
        long sum = 0;
        for (int battery : batteries) {
            sum += Math.min(battery,mid);
        }
        return sum >= n*mid;
    }
}
