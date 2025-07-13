package dailycode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author canyon
 * @date 2025/07/09
 */
public class FindLHS594 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            while(nums[left] > nums[i]) {
                left++;
            }
            if(nums[i] - nums[left]==1) {
                ans = Math.max(ans, i - left+1);
            }
        }
        return ans;
    }
}
