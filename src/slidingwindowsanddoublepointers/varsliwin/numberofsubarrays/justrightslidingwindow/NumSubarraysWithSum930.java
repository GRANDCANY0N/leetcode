package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.justrightslidingwindow;

public class NumSubarraysWithSum930 {
    /**
     * 恰好等于goal可以转换为至少等于goal字串个数减去至少等于goal+1的子串个数差
     * 至少型滑动窗口ans+=left
     * 注意goal等于0的情况，可以看作是所有子串减去子串和至少等于1的字串个数
     * 为什么可以这么减，因为一个数组中，所有子串的个数减去所有和至少等于1的子串的个数只剩下和恰好等于0的个数
     * @param nums 条件数组
     * @param goal 目标值
     * @return int 所有子串和等于goal的子串个数
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solution(nums,goal)-solution(nums,goal+1);
    }
    public static int solution(int[] nums, int goal){
        int left = 0;
        int ans = 0;
        int sum = 0;
        if(goal==0){return nums.length*(nums.length+1)/2;}
        for (int num : nums) {
            sum += num;
            while (sum >= goal) {
                sum -= nums[left++];
            }
            ans += left;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,1};
        int goal = 0;
        System.out.println(new NumSubarraysWithSum930().numSubarraysWithSum(arr,goal));
    }
}
