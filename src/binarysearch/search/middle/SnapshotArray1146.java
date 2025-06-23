package binarysearch.search.middle;

import java.util.HashMap;

import java.util.TreeMap;

/**
 * @author canyon
 * @date 2025/06/23
 * 题目意思是初始化给定长度的一个数据结构
 * set方法修改某个索引的值为val
 * 触发snap方法时，需要保存当前发生过的所有变化并保存snapId
 * 之后根据snapId和索引找到在当时发生snap方法的索引对应的值
 * 解题思路一：
 */
public class SnapshotArray1146 {
    private int snap_id = 0;
    private final HashMap<Integer, TreeMap<Integer, Integer>> data = new HashMap<>();

    /**
     *
     * @param length 给定长度
     */
    public SnapshotArray1146(int length) {
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> history = new TreeMap<>();
            history.put(0, 0);
            data.put(i, history);
        }
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> history = data.get(index);
        history.put(snap_id, val);
        data.put(index,history);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> history = data.get(index);
        HashMap.Entry<Integer, Integer> entry = history.floorEntry(snap_id);
        return entry != null ? entry.getValue() : 0; // fallback 为 0（初始值）
    }
}
