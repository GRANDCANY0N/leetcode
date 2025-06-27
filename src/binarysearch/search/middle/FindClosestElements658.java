package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Canyon
 * @date 2025/06/27
 */
public class FindClosestElements658 extends GenericBinarySearchHelper<Integer,Integer> {
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

    /**
     * 解法1：用二分找到距离x最近的值的索引，然后向两边延拓，直至找到k个数为止
     * 解法2：由于k是定长，可以考虑用滑动窗口，且arr是有序，只需维护最小的绝对值的和记住left索引即可
     * @param arr 数字数组
     * @param k 返回的个数
     * @param x 特定值
     * @return {@link List }<{@link Integer }>基于数组arr，返回k个距离值x的最小的数组成的有序列表
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int sum = 0;
        int start = 0;
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i]-x);
            if(i<k-1){
                continue;
            }
            if(cnt>sum){
                cnt = sum;
                start = left;
            }
            sum -= Math.abs(arr[left++]-x);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i < k+start; i++) {
            list.add(arr[start]);
        }
        return list;
//        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//        int right = lowerBound(nums,x);
//        int left = right-1;
//        int cnt = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//        while(cnt<k){
//            if(right==arr.length){
//                list.add(arr[left]);
//                left--;
//                cnt++;
//                continue;
//            }
//            if (left==-1){
//                list.add(arr[right]);
//                right++;
//                cnt++;
//                continue;
//            }
//            if(Math.abs(arr[left]-x)>Math.abs(arr[right]-x)){
//                list.add(arr[right]);
//                right++;
//            }else {
//                list.add(arr[left]);
//                left--;
//            }
//            cnt++;
//        }
//        list.sort(Comparator.naturalOrder());
//        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(new FindClosestElements658().findClosestElements(arr,4,3));
    }
}
