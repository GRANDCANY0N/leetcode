package slidingwindowsanddoublepointers.slidingwindow;

import java.util.*;

/**
 * @author Canyon
 */
public class MaxSum2841 {
    /**
     * 先将列表转换成数组，开辟哈希表，key为当前值，value为该值出现的次数，窗口滑动，只有满足窗口中不重复元素>=m才更新最大值
     * 每次滑动窗口时将出去的值的次数减1，如果大于0说明窗口中还存在该值，如果为0则不存在，hash表移除该值
     * hash表在这里的作用维护滑动窗口的不重复值的个数
     * @param nums 原列表
     * @param m 允许窗口中不重复元素的个数
     * @param k 滑动窗口的长度
     * @return 求窗口中不重复元素>=m的最大值
     */
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long maxSum = 0;
        Integer[] arr = nums.toArray(Integer[]::new);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(i<k-1){
                continue;
            }
            if(map.size()>=m){
                maxSum = Math.max(maxSum,sum);
            }
            sum -= arr[i-k+1];
            int c = map.get(arr[i-k+1]);
            if(c>1){
                map.put(arr[i-k+1],c-1);
            }else {
                map.remove(arr[i-k+1]);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,4,1,4);
        System.out.println(new MaxSum2841().maxSum(l,2,3));

    }
}
