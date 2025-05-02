package dailycode;

/**
 * @author Canyon
 */
public class FindNumbers1295 {

    /**
     * 找出数组中位数为偶数的数的个数
     * 先计算出这个数的位数 在判断是否为偶数
     * @param nums 条件数组
     * @return int 满足条件的数的个数
     */
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int n = 0;
            while(num>0){
                num /= 10;
                n++;
            }
            if(n%2==0){
                ans++;
            }
        }
        return ans;
    }
}
