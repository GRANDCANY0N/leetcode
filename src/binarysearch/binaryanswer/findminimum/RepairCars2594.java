package binarysearch.binaryanswer.findminimum;

/**
 * @author Canyon
 * @date 2025/07/14
 */
public class RepairCars2594 {
    /**
     * 对于给定时间mid，mid/rank再开根号向下取整就是一个工人在mid时间下完成的car数量
     * car>=规定的cars则说明能提前完成，返回true 缩小时间
     * 否则完不成返回false 增加时间
     * @param ranks 机械工的 能力值数组
     * @param mid 二分得到的修车时间
     * @param cars 总共需要修理的汽车数目
     * @return boolean
     */
    public boolean check(int[] ranks,long mid, int cars){
        int car = 0;
        for (int rank : ranks) {
            car += Math.sqrt(mid/rank);
            if(car>=cars){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * 能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车
     * left设置为0
     * right设置 最小的能力值*car的平方 确定二分范围
     * @param ranks 机械工的 能力值数组
     * @param cars 总共需要修理的汽车数目
     * @return long 修理所有汽车 最少 需要时间
     */
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        for (int rank : ranks) {
            right = Math.min(right,rank);
        }
        right = right * cars * cars;
        while(left+1 < right){
            // >>> 和 >>: >>>是无符号右移 >>是带符号右移
            long mid = (left+right)>>1;
            if(check(ranks, mid, cars)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }
}
