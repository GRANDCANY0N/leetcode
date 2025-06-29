package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

/**
 * @author canyon
 * @date 2025/06/28
 */
public class MinAbsoluteSumDiff1818 extends GenericBinarySearchHelper<Integer,Integer> {
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value < target;
    }

    /**
     * 首先将nums1复制并排序用于二分查找，因为要用自身的数进行替换
     * 以大于等于nums2[i]作为target，在nums1中找到最接近的值，算出来的差值就是这个当前值替换之后最接近的值
     * 由于是大于等于，有可能此时index所在的值没有index-1所在的值跟接近nums2[i]的值，所以要进行判断并且防止数组越界
     * @param nums1 数字数组1
     * @param nums2 数字数组2
     * @return int 将nums1数组中任意一个值替换为nums1数组之后，所得到的最小|nums1[i] - nums2[i]|的差值绝对值的和
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] arr = nums1.clone();
        Arrays.sort(arr);
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        int max = 0;
        long sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];int b = nums2[i];
            int diff = Math.abs(a - b);
            sum += diff;
            int index = lowerBound(array,nums2[i]);
            int best = Integer.MAX_VALUE;

            if (index < arr.length) best = Math.min(best, Math.abs(arr[index] - nums2[i]));       // 可能是 >= target 的第一个数
            if (index > 0)          best = Math.min(best, Math.abs(arr[index - 1] - nums2[i]));
            max = Math.max(max, diff - best);
        }
        return (int)(sum - max+1000000007)%1000000007;
    }
}
