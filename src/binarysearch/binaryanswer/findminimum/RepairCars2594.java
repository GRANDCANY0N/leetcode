package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/12
 */
public class RepairCars2594 {
    public boolean check(int[] ranks, long mid, int cars){
        int car = 0;
        for (int rank : ranks) {
            car += (int)Math.sqrt((double) rank /mid);
            if(car >= cars){
                return true;
            }
        }return false;
    }
    public long repairCars(int[] ranks, int cars) {
        long  left = 0;
        long right = Integer.MAX_VALUE;
        for (int rank : ranks) {
            right = Math.min(right, rank);
        }
        right = right*cars*cars;
        while(left+1<right){
            long mid = (right+left)/2;
            if(check(ranks,mid,cars)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;

    }
}
