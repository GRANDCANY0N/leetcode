package slidingWindow;

public class getAverages_2090 {
    /**
     * 计算索引[i-k,i+k]的窗口中的平均值并放在新数组中，如果两端超出索引则返回-1
     * @param nums 原数组
     * @param k 窗口大小
     * @return 滑动窗口的均值
     */
    public int[] getAverages(int[] nums, int k) {
        int[] arr = nums.clone();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            arr[i] = -1;
            if(i<2*k){
                continue;
            }
            arr[i-k] =(int)( sum / (2*k+1));
            sum -= nums[i-2*k];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {7,4,3,9,1,8,5,2,6};
        int[] averages = new getAverages_2090().getAverages(arr,3);
        for (int average : averages) {
            System.out.print(average+" ");
        }
    }
}
