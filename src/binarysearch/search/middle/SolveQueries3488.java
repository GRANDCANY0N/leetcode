package binarysearch.search.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Canyon
 * @date 2025/06/20
 */
public class SolveQueries3488 {

    /**
     * @param list 对列表进行二分查找
     * @param target 目标值
     * @return int
     */
    public int lowerBound(List<Integer> list, int target){
        int left = -1;
        int right = list.size();
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(list.get(mid)<target){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }

    /**
     * 使用hashMap存储nums中的值和值的位置，位置存放于列表中，由于是顺序遍历，每个值的对应列表是升序的
     * 遍历queries，如果queries[i]对应的nums的值的列表size只有1，说明只出现过一次，因此直接返回-1
     * 之后将queries[i]作为target，找到在list中对应的索引start，此时start左边的索引和右边的索引就是nums中对应的左边距离最近和右边距离最近的两个值
     * 由于是循环数组，所以要先计算nums[left]从左右两边到nums[start]的距离，右边也是如此，最后取一个最小值作为结果
     * @param nums 循环数组
     * @param queries 条件数组
     * @return {@link List }<{@link Integer }> queries中的值作为nums的索引，找到nums[queries[i]]的距离最近的相同值
     * 找到了返回最近的距离，如果没找到就返回-1，将所有值组合成列表
     */
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            List<Integer> list = map.get(nums[queries[i]]);
            int size = list.size();
            if(size==1){
                queries[i] = -1;
                continue;
            }
            int start = lowerBound(list,queries[i]);
            int left = start==0?size-1:start-1;
            int right = start==size-1?0:start+1;
            int leftInd = Math.abs(list.get(left)-list.get(start));
            int rightInd = Math.abs(list.get(right)-list.get(start));
            queries[i] = Math.min(Math.min(leftInd,nums.length-leftInd),Math.min(rightInd,nums.length-rightInd));
        }
        return Arrays.stream(queries).boxed().toList();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,4,1,3,2};
        int[] queries = {0,3,5};
        List<Integer> list = new SolveQueries3488().solveQueries(nums, queries);
        System.out.println(list);
    }
}
