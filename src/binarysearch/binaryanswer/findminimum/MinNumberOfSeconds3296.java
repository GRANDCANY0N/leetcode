package binarysearch.binaryanswer.findminimum;

/**
 * @author Canyon
 * @date 2025/07/08
 */
public class MinNumberOfSeconds3296 {
    /**
     * 根据时间来计算每个工人能完成的高度，用原始高度减去每个工人在mid时间下完成的高度
     * 如果原始高度<=0说明可以完成，时间充裕可以缩减时间，否则完不成需要增加时间
     * 主要难点在于
     * 给定一个正整数 S，我们想找最大的整数 x，使得
     * 1+2+3+⋯+x = (x+1)*x/2<=S,要找到最大的x
     * mid / workTime是这个S
     * ((int) Math.sqrt(mid / workTime * 8 + 1) - 1) / 2是这个x 套用求根公式求出来的
     * @param workTimes 每个工人工作时间的数组
     * @param mid 传入的二分时间
     * @param mountainHeight 规定高度
     * @return boolean
     */
    public boolean check(int[] workTimes, long mid, int mountainHeight){
        int high = 0;
        for (int workTime : workTimes) {
            mountainHeight -= ((int) Math.sqrt(mid / workTime * 8 + 1) - 1) / 2;
            if(mountainHeight<=0){
                return true;
            }
        }
        return false;
    }

    /**
     * 最大边界值找到时间花费最小的工人完成整座山的所需时间
     * 之后调用check函数，返回true说明时间有余，移动right，否则时间不足，移动left
     * @param mountainHeight 每个工人工作时间的数组
     * @param workerTimes 规定高度
     * @return long 工人们使山的高度降低到 0 所需的 最少 秒数
     */
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        for (int workerTime : workerTimes) {
            right = Math.min(right,workerTime);
        }
        right = (right+right*mountainHeight)*mountainHeight/2;
        while (left+1<right){
            long mid = (left+right)>>>1;
            if(check(workerTimes,mid,mountainHeight)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }
}
