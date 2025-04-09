package dailyCode;

public class maximumTripletValue_2873 {
    public long maximumTripletValue(int[] nums) {

        //暴力
        int len = nums.length;
        long sum =  0L;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    sum = Math.max((long) (nums[i] - nums[j]) * (long) nums[k],sum);
                }
            }
        }
        return sum;
    }
}
