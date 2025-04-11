package slidingWindow;

public class findMaxAverage_643 {
    /**
     * 找到定长k的窗口中最大的平均数
     * @param nums 给定数组
     * @param k 定长窗口长度k
     * @return 最大的平均数
     */
    public double findMaxAverage(int[] nums, int k) {
        int ant = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i<k-1){
                sum += nums[i];
                continue;
            }
            ant = Math.max(sum,ant);
            sum -= nums[i-k+1];
        }
        return (double) ant/k;
    }
}
