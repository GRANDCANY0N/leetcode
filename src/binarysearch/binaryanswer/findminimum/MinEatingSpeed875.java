package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/05
 */
public class MinEatingSpeed875 {
    /**
     * @param nums 香蕉数组
     * @param mid 二分传入的
     * @param h
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
    public int minEatingSpeed(int[] piles, int h) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
            left = Math.min(left, pile);
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
