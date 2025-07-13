package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/10
 */
public class FindRadius475 {
    public boolean check(int[] heaters, int mid,int left, int right){
        int len = left-1;
        for (int heater : heaters) {
            if(heater - mid > len+1){
                return false;
            }
            len = heater+mid;
            if(len >= right){
                return true;
            }
        }
        return false;
    }

    public int findRadius(int[] houses, int[] heaters) {
        int left = 0;
        int right = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while (left+1 < right) {
            int mid = (left + right) >>>1;
            if(check(heaters, mid,houses[0], houses[houses.length - 1])){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] houses = {1,2,3,5,15};
        int[] heaters = {2,30};
        FindRadius475 f = new FindRadius475();
        System.out.println(f.findRadius(houses, heaters));
    }
}
