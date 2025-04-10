package slidingWindow;

public class numOfSubArrays_1343 {
    /**
     * 求数组中长度等于k的窗口的平均值大于threshold的窗口数
     * @param arr 原数组
     * @param k 固定窗口大小
     * @param threshold 平均值门槛
     * @return 窗口个数
     */
    //tip:可以把计算的先在循环外计算出来，节省循环计算时间
    public int numOfSubArrays(int[] arr, int k, int threshold) {
        int sum = 0;int ant = 0;
        threshold *= k;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(i<k-1){
                continue;
            }
            if(sum>=threshold){
                ant++;
            }
            sum -= arr[i-k+1];
        }
        return ant;
    }
}