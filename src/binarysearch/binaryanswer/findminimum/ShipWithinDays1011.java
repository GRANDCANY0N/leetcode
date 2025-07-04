package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/04
 */
public class ShipWithinDays1011 {
    /**
     * @param nums 原数组
     * @param mid 自定的二分mid
     * @param days 门槛天数
     * @return int 返回0说明此时天数超了，需要扩大能力，否则返回最大的运载能力
     */
    public int check(int[] nums, int mid, int days){
        int sum = 0;
        int day = 0;
        int max = 0;int i = 0;
        while(i<nums.length){
            if((sum+nums[i]) <= mid){
                day++;
                max = Math.max(max, sum);
                sum = 0;
            }else {
                sum += nums[i];
                i++;
                max = Math.max(max, sum);
            }
            if(day >= days){
                return 0;
            }
        }
        return max;
    }

    /**
     * 首先确定check数组的范围，最小的重量范围应该是数组的最大值，最大的重量范围为数组的和
     * 取最小值-1和最大值的中间mid，每次装到小于等于mid时将此时的维护重量的sum置为0
     * 如果装完了天数还小于days,说明可以扩大mid，left=mid，反之装不下了 right = mid
     * @param weights 传送带重量数组 必须按序装入
     * @param days 天数
     * @return int 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力
     */
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight)-1;
            right += weight;
        }
        int ans = right;
        while(left+1<right){
            int mid = (left+right)>>>1;
            int result = check(weights, mid, days);
            if(result>0){
                ans = Math.min(ans,result);
                right = mid;
            }else {
                left = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] weights = {407,59,416,189,326,109,399,404,181,275,135,57,147,7,158,201,218,111,56,9,149,231,186,293,187,395,75,100,334,23,327,434};
        System.out.println(new ShipWithinDays1011().shipWithinDays(weights, 32));
    }
}
