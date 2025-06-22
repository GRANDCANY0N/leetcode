package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

public class FindTheDistanceValue1385 extends GenericBinarySearchHelper<Integer,Integer> {
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value < target;
    }

    /**
     * 先找到大于等于i-d的值的位置start，如果此时start在最右边说明i-d已经是arr2中最大的值，满足条件
     * 如果start在其他地方，只需要考虑arr2[start]的值的情况，如果arr2[start]>i+d，说明[i−d,i+d]这个区间里不存在arr2的值
     * 由于数组是有序的所以也满足情况
     * @param arr1 数字数组1
     * @param arr2 数字数组2
     * @param d 不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d
     * @return int 不存在的个数
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Integer[] nums1 = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Integer[] nums2 = Arrays.stream(arr2).boxed().toArray(Integer[]::new);
        for (Integer i : nums1) {
            int start = lowerBound(nums2, i-d);
            if(start == arr2.length || arr2[start] > i+d){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,4,2,3};
        int[] arr2 = {-4,-3,6,10,20,30};
        System.out.println(new FindTheDistanceValue1385().findTheDistanceValue(arr1, arr2, 3));
    }
}
