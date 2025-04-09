package slidingWindow;

public class findMaxAverage_643 {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i<k-1){
                sum += nums[i];
                continue;
            }
            avg = Math.max(sum/k,avg);
            sum -= nums[i-k+1];
        }
        return avg;
    }
}
