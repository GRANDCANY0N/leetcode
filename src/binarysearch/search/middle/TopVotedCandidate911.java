package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author canyon
 * @date 2025/06/29
 * 题目意思是按照时间顺序给不同的选举人进行投票，返回给定时间条件下票数最高的选举人id
 */
public class TopVotedCandidate911 extends GenericBinarySearchHelper<Integer,Integer> {
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value < target;
    }

    private final List<Integer> list = new ArrayList<>();
    private final int[] time ;

    /**
     * 初始化选举人id和时间数组
     * 考虑用map来记录选举人id和对应的票数
     * 添加list记录每个时刻票数最高的选举人id
     * 具体方法：maxVotes记录此时最高的票数 leader作为票数最高的选举人id
     * 每次更新选举人id对应的票数，当此时这个选举人对应票数大于等于maxVotes，说明他是这个时间段票数最多的选举人（同票时间进的获胜）
     * 更新maxVotes和leader，将leader加入list中
     * @param persons 选举人id数组
     * @param times 时间数组
     */
    public TopVotedCandidate911(int[] persons, int[] times) {
        this.time = times;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxVotes = 0;
        int leader = -1;
        for (int p : persons) {
            map.merge(p, 1, Integer::sum);
            if (map.get(p) >= maxVotes) {
                maxVotes = map.get(p);
                leader = p;
            }
            list.add(leader);
        }
    }

    /**
     * 通过二分查找时间数组，以大于等于t作为target
     * 由于list是按照时间数组记录每个时刻票数最多的选举人id，根据二分查找的索引就可以直接在list中直接获得给定时间时票数最高的选举人id
     * @param t 给定时间
     * @return int 返回给定时间时票数最高的选举人id
     */
    public int q(int t) {
        Integer[] array = Arrays.stream(time).boxed().toArray(Integer[]::new);
        int index = lowerBound(array,t);
        return list.get(index);
    }
}
