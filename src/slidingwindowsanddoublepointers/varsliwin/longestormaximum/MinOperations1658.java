package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

/**
 * @author Canyon
 */
public class MinOperations1658 {
    public int minOperations(int[] nums, int x) {
        int left = 0;int lens= nums.length;
        int right=lens-1;int ans=Integer.MAX_VALUE;
        for ( ;left < lens; left++) {
            x -= nums[left];
            if(x<0){
                break;
            }
            if(x==0){
                ans = Math.min(left+1,ans);
            }
        }
        if(left==lens&& ans==Integer.MAX_VALUE){
            return -1;
        } else if (left == lens) {
            return ans;
        }
        x += nums[left--];
        while (x>=0) {
            x -= nums[right--];
            while(x<=0&&left>=0){
                x += nums[left--];
            }
            if(x==0){
                ans = Math.min(lens-right+left,ans);
            }

        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public static void main(String[] args) {
        int[] arr = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
        System.out.println(new MinOperations1658().minOperations(arr,134365));
    }
}
