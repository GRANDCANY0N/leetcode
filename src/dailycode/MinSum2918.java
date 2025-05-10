package dailycode;

/**
 * @author Canyon
 */
public class MinSum2918 {
    /**
     * 找到-1的情况，如果出现一个数组中没有0且数组的和小于另一个数组，这种情况则永远不能使两个数组相等
     * 剩下的情况就是比较两个数组和加上0的个数，返回最大的一个
     * @param nums1 条件数组1
     * @param nums2 条件数组2
     * @return long 将数组1和数组2中的0变为正整数的同时最小的和，否则返回-1
     */
    public long minSum(int[] nums1, int[] nums2) {
        int cntNums1Zero = 0;int cntNums2Zero = 0;
        long nums2Sum = 0; long nums1Sum = 0;
        for (int i : nums1) {
            if(i==0){
                cntNums1Zero++;
            }else {
                nums1Sum+=i;
            }
        }
        for (int i : nums2) {
            if(i==0){
                cntNums2Zero++;
            }else {
                nums2Sum+=i;
            }
        }
        if((cntNums2Zero==0 && nums2Sum<nums1Sum+cntNums1Zero)){
            return -1;
        }
        if((cntNums1Zero==0 && nums1Sum<nums2Sum+cntNums2Zero)){
            return -1;
        }
        return Math.max(nums1Sum+cntNums1Zero,nums2Sum+cntNums2Zero);
    }
}
