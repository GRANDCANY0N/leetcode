package binarysearch.search.base;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

public class MaximumCount2529 extends GenericBinarySearchHelper<Integer> {
    /**
     * 重写比较方法，改为Integer类型的比较
     */
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value < target;
    }

    /**
     * 大于等于1 然后用数组长度减去就是正整数最大的个数
     * 小于0 就是负整数的个数
     * @param nums 数字数组
     * @return int 负整数和正整数个数的最大值
     */
    public int maximumCount(int[] nums) {
        //java提供的将数组类型装箱的快速方法
        Integer[] integerArray = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);
        int pos = lowerBound(integerArray,1);
        int meg = lowerBound(integerArray,0);
        return Math.max((nums.length - pos), (meg));
    }
}
