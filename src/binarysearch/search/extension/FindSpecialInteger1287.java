package binarysearch.search.extension;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

/**
 * @author Canyon
 * @date 2025/07/01
 */
public class FindSpecialInteger1287 extends GenericBinarySearchHelper<Integer,Integer> {
    /**
     * 由于是泛型，所以具体的继承要重写为对应的类型比较
     *
     * @param value  数组中的值
     * @param target 目标值
     * @return boolean 比较方法
     */
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value<target;
    }

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int target = length/4;
        int a = (-1+length)>>>1;
        int b = (-1+a)>>>1;
        int c = (a+length)>>>1;
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        int startA = lowerBound(nums,arr[a]);
        int endA =  lowerBound(nums,arr[a]+1);
        if(endA-startA>target){
            return arr[a];
        }
        int startB = lowerBound(nums,arr[b]);
        int endB =  lowerBound(nums,arr[b]+1);
        return a;
    }
}
