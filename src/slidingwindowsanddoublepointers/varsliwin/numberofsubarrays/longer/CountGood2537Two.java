package slidingwindowsanddoublepointers.varsliwin.numberofsubarrays.longer;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class CountGood2537Two {
    /**
     * hashMap维护每个数字出现的次数，cnt维护相同值不同索引的次数，cnt大于等于k时说明子串已经满足条件
     * 此时之后的也都会满足条件，移动left直至不能满足条件
     * @param nums 条件数组
     * @param k 数组中相同值需要满足的个数
     * @return long 所有的相同值满足k的子串个数
     */
    public long countGood(int[] nums, int k) {
        long ans = 0;
        long cnt = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>(2);
        for (int num : nums) {
            map.merge(num,1,Integer::sum);
            cnt += map.get(num)-1;
            while(cnt>=k){
                int value = map.get(nums[left]);
                cnt -= value-1;
                if(value>1){
                    map.put(nums[left],value-1);
                }else {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={3,1,4,3,2,2,4};
        System.out.println(new CountGood2537Two().countGood(arr,2));
    }
}
