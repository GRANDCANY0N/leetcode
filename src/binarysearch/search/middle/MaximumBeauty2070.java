package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author canyon
 * @date 2025/06/22
 */
public class MaximumBeauty2070 extends GenericBinarySearchHelper<int[],Integer> {
    @Override
    protected boolean compare(int[] value, Integer target) {
        return value[0] < target;
    }
    /**
     * 先用hashMap装载价格和对应价格的最大的美丽值
     * 提炼出价格数组进行排序
     * 将queries[i]作为target 找到小于等于target的索引start 对应的hashMap的值就是最大的美丽值
     * 要考虑如果right没发生变化，则等于价格数组的length-1
     * 空间复杂度(n+hashMap) 时间复杂度(n+nlogN)
     * @param items 包含价格和美丽值的数组
     * @param queries 要查询的数组
     * @return {@link int[] } 价格小于等于queries的同时最大的美丽值的数组
     * 方法二：先按照价格进行排序
     * 之后更新美丽值，美丽值只需要更新此次索引之前的最大值
     * 因为价格排序且需要最大的美丽值，如果前面的价格对应的美丽值比现在的美丽值大，依然要取前面的美丽值
     * 具体写法：items[i][1] = Math.max(items[i-1][1],items[i][1])
     * 将queries[i]作为target，用价格数组进行二分，按照题目要求小于等于target
     */

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i-1][1], items[i][1]);
        }
        for (int i = 0; i < queries.length; i++) {
            int start = lowerBound(items, queries[i]+1)-1;
            queries[i] = start<0?0:items[start][1];
        }
        return queries;

//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int[] item : items) {
//            if (item[1] > map.getOrDefault(item[0], 0)) {
//                map.put(item[0], item[1]);
//            }
//        }
//        int[] keys = map.keySet()
//                .stream()
//                .mapToInt(Integer::intValue)
//                .sorted() // 升序
//                .toArray();
//        Integer[] array = Arrays.stream(keys).boxed().toArray(Integer[]::new);
//        for (int i = 0; i < queries.length; i++) {
//            int start = lowerBound(array, queries[i]+1)-1;
//            queries[i] = map.get(keys[start]);
//        }
//        return queries;
    }

    public static void main(String[] args) {
        int[][] items = {{1,1}, {1,2}, {1,4}, {1,3}};
        int[] queries = {1};
        System.out.println(Arrays.toString(new MaximumBeauty2070().maximumBeauty(items, queries)));
    }
}
