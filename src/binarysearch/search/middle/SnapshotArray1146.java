package binarysearch.search.middle;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;


/**
 * @author canyon
 * @date 2025/06/23
 * 题目意思是初始化给定长度的一个数据结构
 * set方法修改某个索引的值为val
 * 触发snap方法时，需要保存当前发生过的所有变化并保存snapId
 * 之后根据snapId和索引找到在当时发生snap方法的索引对应的值
 * 解题思路一：
 * 首先初始化，HashMap存储的是每个值的索引和对应的treeMap
 * treeMap存储的是当前索引每次快照的id和值
 * 例如初始化<0, <[0,0]>> 第一次set之后<0, <[0,5]>> 第一次快照之后再set <0, <[0,5],[1,6]>>
 * 要查找某个索引某次快照对应的值 只需要根据hashMap的键查找对应的treeMap，之后snapId作为target，二分查找小于等于target
 * 为什么是小于等于，因为treeMap只更新变化的值，如果一个索引的treeMap没有此次snapId，说明从最近的一次snapId之后就没有更新过
 * 截图思路二：
 * treeMap可以用list收集(snapId,value)的元组代替，因为snapId是有序的，所以无需再用treeMap营造有序的key
 */
public class SnapshotArray1146 {
    private int snapId;
    private final HashMap<Integer, List<int[]>> map = new HashMap<>();
    public SnapshotArray1146(int length) {

    }

    public void set(int index, int val) {
        map.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{snapId,val});
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        if(!map.containsKey(index)){
            return 0;
        }
        int key = lowerBound(map.get(index),snapId+1)-1;
        return key < 0 ? 0:map.get(index).get(key)[1];

    }

    public int lowerBound(List<int[]> list,int target){
        int left = -1;
        int right = list.size();
        while (left + 1 < right) {
            int mid =(left + right) >>>1;
            if(list.get(mid)[0]<target){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }

//    private int snapId = 0;
//    private final HashMap<Integer, TreeMap<Integer, Integer>> data = new HashMap<>();
//
//    /**
//     *
//     * @param length 给定长度
//     */
//    public SnapshotArray1146(int length) {
//        for (int i = 0; i < length; i++) {
//            TreeMap<Integer, Integer> history = new TreeMap<>();
//            history.put(0, 0);
//            data.put(i, history);
//        }
//    }
//
//    public void set(int index, int val) {
//        TreeMap<Integer, Integer> history = data.get(index);
//        history.put(snapId, val);
//        data.put(index,history);
//    }
//
//    public int snap() {
//        return snapId++;
//    }
//
//    public int get(int index, int snapId) {
//        TreeMap<Integer, Integer> history = data.get(index);
//        HashMap.Entry<Integer, Integer> entry = history.floorEntry(snapId);
//        return entry != null ? entry.getValue() : 0;
//    }
}
