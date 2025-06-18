package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

/**
 * @author Canyon
 */
public class AnswerQueries2389 extends GenericBinarySearchHelper<Integer> {
    /**
     * 由于是泛型，所以具体的继承要重写为对应的类型比较
     *
     * @param value  数组中的值
     * @param target 目标值
     * @return boolean 比较方法
     */
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value < target;
    }

    /**
     * 方法1：先将nums排序，将queries作为target找到start 遍历[0,start-1]的索引找到最长的子序列
     * 方法2：先将nums排序，然后从索引1开始用当前值加上前一个值，这样每个索引的都是nums[0,i]的和
     * @param nums 数字数组
     * @param queries 查询数组
     * @return {@link int[] } 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i]的子序列(可以对原数组排序)的最大长度
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        //前缀和
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        for (int i = 0; i < queries.length; i++) {
            int start = lowerBound(arr,queries[i]);
            queries[i] = start;
        }
        return queries;
    }
}
