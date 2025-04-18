package dailycode;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class CountBadPairs2364 {
    /**
     * 先将题目要求j-i!=nums[j]-nums[i],变形成 nums[i]-i != nums[j] -j;
     * 反过来用总数对减去nums[i]-i == nums[j] -j的数对，相等的数对用hash表单次循环即可
     * 先用hash表统计相等的数对的数目，然后用总数对减去相等的数对的数目就是坏数对的数目
     * @param nums 原数组
     * @return 坏数对的个数
     */
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        long ant = 0;
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i]-i,hashMap.getOrDefault(nums[i]-i,0)+1);
            long sum = hashMap.get(nums[i]-i);
            //ant += (sum*(sum-1) - (sum-1)*(sum-2))/2;
            ant += sum -1;
        }
        return (long)nums.length*(nums.length-1)/2 - ant;
//        //暴力超时
//        int ant = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//
//                if(j - i != (nums[j] - nums[i])){
//                    ant++;
//                }
//            }
//        }
//        return  ant;
    }
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        System.out.println(new CountBadPairs2364().countBadPairs(arr));
    }

}
