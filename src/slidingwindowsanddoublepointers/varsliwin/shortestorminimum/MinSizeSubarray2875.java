package slidingwindowsanddoublepointers.varsliwin.shortestorminimum;

/**
 * @author Canyon
 */
public class MinSizeSubarray2875 {
    /**
     * 首先先计算出一次数组的全部和sum， 如果target大于sum说明需要不止一次的全部和sum，剩下的部分考虑余数
     * 题目换算成target/sum的次数*length 加上 余数的最短长度
     * 用数组的长度*2，考虑最短余数是头和尾的情况
     * 遍历数组，当和>余数时，移动left，直至和小于等于余数
     * 只有当和等于余数才满足条件，计算长度
     * 需要注意的是由于数组*2,所以left和i都需要对length取余
     * 如果ans没发生变化，说明数组中不存在子串等于余数，返回-1
     * @param nums 条件数组
     * @param target 在数组无限拼接的情况下达到target值
     * @return int 在数组无限拼接的情况下最短的达到target值的子串的长度
     */
    public int minSizeSubarray(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 0; i < n * 2; i++) {
            num += nums[i%n];
            while(num>(target%sum)){
                num -= nums[left%n];
                left++;
            }
            if(num==target%sum){
                ans = Math.min(ans,i-left+1);
            }

        }
        return ans==Integer.MAX_VALUE?-1:ans+(target/sum)*n;
//        int sum = 0;
//        for (int num : nums) {
//            sum+=num;
//        }
//        int lens = nums.length;
//        int cnt = target / sum +1;
//        int ans = lens*cnt;int right = 0; int i = 0;
//        int len=0;sum=0;int left=0;
//        while(right<lens && i<=cnt){
//            sum+=nums[right];
//            len++;right++;
//            while(sum>=target){
//                if(sum==target){
//                    ans = Math.min(ans,len);
//                }
//                sum -= nums[left];
//                left++;len--;
//                if(left==lens){
//                    left=0;
//                }
//            }
//            if(right==lens){
//                right=0;i++;
//            }
//        }
//        return ans==lens*cnt?-1:ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3};
        System.out.println(new MinSizeSubarray2875().minSizeSubarray(arr,4));
    }
}
