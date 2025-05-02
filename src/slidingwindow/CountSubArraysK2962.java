package slidingwindow;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class CountSubArraysK2962 {
    /**
     * 第一次循环，先找到最大值
     * 第二次循环，每次循环加上最左边的索引，只有当最大值的个数满足要求k时，才会移动left，此时left到第一个最大值的索引都会满足条件，
     * 且最右边的最大值到最右边的值都会满足，因此后面的循环都可以加上left
     * @param nums 原数组
     * @param k 最大值的个数至少大于等于k
     * @return 满足最大值个数大于等于k的个数
     */
    public long countSubArrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num,max);
        }
        long ans = 0;
        int left = 0; int cnMax = 0;
        for (int num : nums) {
            if (num == max) {
                cnMax++;
            }
            while (cnMax == k) {
                if (nums[left] == max) {
                    cnMax--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }

    /**
     * 滑动窗口，遍历一次，如果此时数组中的值大于max，将ans变为0
     * 每次循环判断最大值的个数是否等于k，等于的话right指针先不动，开始移动左指针，直至个数小于k再开始移动right
     * @param nums 原数组
     * @param k 要求子数组中的最大值至少出现的次数
     * @return 满足条件的字串个数
     */
    public long countSubArraysOne(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = Integer.MIN_VALUE;;int right = 0;
        int left = 0;int lens = nums.length;boolean flag = true;
        while (right < lens) {
            if(max < nums[right]){
                max = nums[right];
                ans = 0;
                left = 0;
            }
            if(flag){
                hashMap.merge(nums[right],1,Integer::sum);
            }
            if(hashMap.getOrDefault(max, 0).equals(k)){
                flag = false;
                ans += (lens - right);
                int value = hashMap.get(nums[left]) - 1;

                hashMap.put(nums[left],value);

                left++;
            }else {
                flag = true;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49};
        System.out.println(new CountSubArraysK2962().countSubArrays(arr,1));
    }
}
