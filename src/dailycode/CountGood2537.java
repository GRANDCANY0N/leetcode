package dailycode;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class CountGood2537 {
    /**
     * 不定长的滑动窗口，使用sum来记录满足k的对数，left维护尾部的索引，每次循环维护sum
     * 当存在sum>=k时，则说明left到i的子串已经满足要求，从left到nums.length-1的所有也一定满足要求
     * 此时移动left，找到不满足的数之后在移动i，每次移动left维护sum的变化
     * @param nums 原数组
     * @param k 要求对子的数
     * @return 满足k的对子数的字串个数
     */
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Long> map = new HashMap<>(nums.length);
        int ant = 0;long sum = 0;
        int left = 0;int i = 0;boolean flag = true;
        while (i < nums.length) {
            if (flag) {
                map.put(nums[i], map.getOrDefault(nums[i], 0L)+1);
                long val = map.get(nums[i]);
                if((map.get(nums[i]))>=2){
                    sum += ((val * (val-1)) - (val-1)* (val-2)) / 2;
                }
            }
            flag = true;
            if(sum >= k){
                ant += nums.length - i;
                flag = false;
                long c = map.get(nums[left])-1;
                sum -= ((c+1) * c - (c * (c-1))) / 2;
                if(c < 1){
                    map.remove(nums[left]);
                }else {
                    map.put(nums[left],c);
                }
            }
            if(!flag){
                left++;
            }else {
                i++;
            }
        }
        return ant;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,1,2,2,3,3,2,2,1,1,1,3,1};
        long l = new CountGood2537().countGood(arr, 11);
        System.out.println(l);
    }
}
