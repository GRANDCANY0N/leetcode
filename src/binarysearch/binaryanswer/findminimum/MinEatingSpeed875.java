package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/05
 */
public class MinEatingSpeed875 {
    /**
     * 用piles[i]/mid向上取整算出每个香蕉堆需要花费的时间
     * 如果hours>h说明吃不完 直接返回false，否则可以吃完，返回true
     * @param nums 香蕉数组
     * @param mid 二分传入的吃香蕉速度
     * @param h 规定时间
     * @return boolean
     */
    public boolean check(int[] nums, int mid, int h){
        int hours = 0;
        int i = 0;
        while (i < nums.length){
            hours  += (nums[i]+mid-1)/mid;
            i++;
            if(hours > h){
                return false;
            }
        }
        return true;
    }

    /**
     * 如果速度大于piles[i],即使吃完也不能再吃下一个
     * 对于速度k，考虑用piles[i]/k向上取整，这就是吃完一堆的花费时间
     * 构建二分数组，题目要求piles.length <= h 所以最快的速度边界是piles的最大值，最小的速度边界是0，开区间left=0
     * 每次调用check函数检查此次的mid是否满足小于等于h，满足则说明速度可以降低，移动right，否则吃不完说明速度需要增加，移动left
     * @param piles 香蕉数组
     * @param h 规定时间
     * @return int 规定时间内吃掉所有香蕉的最小速度
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while(left +1 < right){
            int mid = (left + right) >>> 1;
            if (check(piles, mid, h)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;

    }

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        System.out.println(new MinEatingSpeed875().minEatingSpeed(piles, 5));
    }
}
