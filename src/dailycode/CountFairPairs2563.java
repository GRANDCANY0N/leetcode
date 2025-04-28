//package dailycode;
//
//import java.util.Arrays;
//
///**
// * @author Canyon
// */
//public class CountFairPairs2563 {
//    public long countFairPairs(int[] nums, int lower, int upper) {
//        int left = nums.length / 2 - 1;
//        int right = left + 1;
//        long ant = 0;
//        Arrays.sort(nums);
//        while (left>=0 && right < nums.length){
//            long sum = nums[left] + nums[right];
//            if(sum >upper){
//                left --;
//            }else if(sum<lower){
//                right++;
//            }
//        }
//
//    }
//}
