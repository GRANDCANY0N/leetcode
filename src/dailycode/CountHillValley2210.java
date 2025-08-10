package dailycode;


public class CountHillValley2210 {
    /**
     * 整体思路：
     * 先对数组连续的重复数去重
     * 之后判断是否存在谷和峰
     * -
     * 步骤：
     * 在原数组上去重，nums[0] 是第一个连续相同段的第一个元素，保留。
     * 如果 nums[i]!=nums[i−1]，那么 nums[i] 是一个新的连续相同段的第一个元素，保留。
     * 之后循环判断nums[i]是否同时大于或小于nums[i−1]和nums[i+1]
     * -
     * 复杂度：
     * 空间复杂度 在原数组上修改 O(1)
     * 时间复杂度 去重加判断 O(N+N)
     * @param nums 整数数组
     * @return int 返回 nums 中峰和谷的数量
     */
    public int countHillValley(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        int ans = 0;
        for (int i = 1; i < k - 1; i++) {
            if((nums[i]>nums[i-1])==(nums[i]>nums[i+1])){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={2,4,1,1,6,5};
        System.out.println(new CountHillValley2210().countHillValley(arr));
    }
}
