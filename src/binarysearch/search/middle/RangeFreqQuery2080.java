package binarysearch.search.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Canyon
 * @date 2025/06/27
 * 题目含义：对一个数组建立数据结构，方便快速查询在数组索引[left,right]中值等于value的个数
 * 解题思路：
 * 考虑构建HashMap(value,list(index))的数据结构
 * 遍历数据，存入map中的key为value，value为每个key的索引，由于是遍历所以list是有序的
 * 查询时对list进行二分，大于等于left和小于right作为target
 */
public class RangeFreqQuery2080 {
    private final HashMap<Integer, List<Integer>> map = new HashMap<>();
    public RangeFreqQuery2080(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }
    public int lowerBound(List<Integer> list, int target){
        int left = -1;
        int right = list.size();
        while(left+1<right){
            int mid = (right+left)>>>1;
            if(list.get(mid)<target){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
    public int query(int left, int right, int value) {
        if(!map.containsKey(value)){
            return 0;
        }
        List<Integer> list = map.get(value);
        return lowerBound(list, right + 1) - lowerBound(list, left);
    }
}
