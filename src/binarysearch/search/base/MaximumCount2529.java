package binarysearch.search.base;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

public class MaximumCount2529 extends GenericBinarySearchHelper<Integer> {
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value < target;
    }
    public int maximumCount(int[] nums) {
        Integer[] integerArray = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);
        int pos = lowerBound(integerArray,1);
        int meg = lowerBound(integerArray,0);
        return Math.max((nums.length - pos), (meg));
    }
}
