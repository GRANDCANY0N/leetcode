package dailycode;

/**
 * @author Canyon
 */
public class CountSubArrays3392 {
    /**
     * 模板滑动窗口
     * @param nums 原数组
     * @return 符合要求的字串个数
     */
    public int countSubArrays(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            if(i<2){
                continue;
            }
            if((nums[i-2]+nums[i]) *2  == nums[i-1]){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-4,-1,4};
        System.out.println(new CountSubArrays3392().countSubArrays(arr));
    }
}
