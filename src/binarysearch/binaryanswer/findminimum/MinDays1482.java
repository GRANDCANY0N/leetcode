package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/13
 */
public class MinDays1482 {
    public boolean check(int[] bloomDay, int mid, int m, int k){
        int flower = 0;
        boolean flag = true;
        for (int i = 0; i < bloomDay.length;) {
            int j = 0;
            while(j<k&&i<bloomDay.length){

            }

            flower++;
            if(flower>=m){
                return true;
            }
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<m*k){
            return -1;
        }
        int left = 0;
        int right = 0;
        for (int i : bloomDay) {
            right = Math.max(right, i);
        }
        while (left+1 < right) {
            int mid = (left + right)>>>1;
            if(check(bloomDay, mid,m,k)){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        System.out.println(new MinDays1482().minDays(bloomDay,2,3));
    }
}
