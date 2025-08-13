package datastructure.enumtech.enumrmaintainl.base;

import java.util.Arrays;
import java.util.HashMap;


/**
 * @author Canyon
 * @date 2025/08/13
 */
public class TwoSum1 {
    /**
     * 整体思路：
     * hashMap存储每个值与target的差值，直至当前值在hashMap中找到
     * -
     * 步骤：
     * 遍历数组，hashMap存储每个值与target的差值
     * 如果当前值nums[i]存在hashMap中，返回索引
     * -
     * 复杂度：
     * - 时间复杂度： 一次遍历 O(N)
     * - 空间复杂度： hashMap 最差O(N)

     * @param nums 整数数组
     * @param target 给定的两数之和
     * @return {@link int[] } 返回数组中两数之和等于target的索引数组
     */
    public int[] twoSum(int[] nums, int target) {
        //不指定初始数组大小，第一次put默认扩容到16
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }else {
                map.put(target-nums[i],i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3};
        System.out.println(Arrays.toString(new TwoSum1().twoSum(arr, 4)));
    }
}
