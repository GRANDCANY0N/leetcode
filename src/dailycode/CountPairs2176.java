package dailycode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Canyon
 */
public class CountPairs2176 {
    /**
     * 暴力方法就是二重循环
     * 使用hashmap，value改为存储相同key索引的列表，时间复杂度为O(NlogN)
     * @param nums 原数组
     * @param k 被整除的数
     * @return 数组值相同且索引相乘被k整除的个数
     */
    public int countPairs(int[] nums, int k) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int ant = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                for (int oldIndex : map.get(nums[i])) {
                    if(oldIndex*i%k==0){
                        ant++;
                    }
                }
            }
            map.computeIfAbsent(nums[i], j -> new ArrayList<>()).add(i);
        }
        return ant;
//        //暴力
//        int ant = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if(nums[i]==nums[j]){
//                    if(i==0){
//                        ant++;
//                    }else if((i*j)%k==0){
//                        ant++;
//                    }
//                }
//            }
//        }
//        return ant;
    }

    public static void main(String[] args) {
        int n = 100_000;
        int[] nums = new int[n];
        int k = 10;

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = rand.nextInt(500);
        }

        // 计时 HashMap 方法
        long start1 = System.currentTimeMillis();
        int result1 = countPairsMap(nums, k);
        long end1 = System.currentTimeMillis();
        System.out.println("HashMap 方法结果：" + result1 + "，耗时：" + (end1 - start1) + " ms");

        // 计时 暴力方法（⚠️ 会很慢，不建议开太大）
        long start2 = System.currentTimeMillis();
        int result2 = countPairsBruteForce(nums, k);
        long end2 = System.currentTimeMillis();
        System.out.println("暴力方法结果：" + result2 + "，耗时：" + (end2 - start2) + " ms");
    }

    // HashMap 方法
    public static int countPairsMap(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int ant = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                for (int oldIndex : map.get(nums[i])) {
                    if (oldIndex * i % k == 0) {
                        ant++;
                    }
                }
            }
            map.computeIfAbsent(nums[i], j -> new ArrayList<>()).add(i);
        }
        return ant;
    }

    // 暴力方法
    public static int countPairsBruteForce(int[] nums, int k) {
        int ant = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    ant++;
                }
            }
        }
        return ant;
    }

}
