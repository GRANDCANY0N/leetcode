package slidingwindow;

/**
 * @author Canyon
 */
public class MaxScore1423 {
    /**
     * 第一个循环从头开始，获取k个值，
     * 第二个循环每次减去头部最后一个数，加上尾部第一个数，比较最大值
     * @param cardPoints 原数组
     * @param k 滑动窗口长度
     * @return 每次只允许选择头尾的数，返回滑动窗口长度的最大值
     */
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0; int maxSum = 0;
        int i = 0;
        while(true) {
            sum += cardPoints[i];
            if(i<k-1){
                i++;
                continue;
            }
            maxSum = Math.max(maxSum, sum);
            break;
        }
        int length = cardPoints.length-1;
        for (int j = i; j>= 0; j--) {
            sum -= cardPoints[j];
            sum += cardPoints[length--];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        int score = new MaxScore1423().maxScore(arr, 3);
        System.out.println(score);
    }


}
