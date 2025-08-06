package binarysearch.binaryanswer.findmaximum;

import java.util.Arrays;

public class MaxNumOfMarkedIndices2576 {
    public boolean check(int[] nums,int mid){
        int right = nums.length-1;
        int left = right-1;
        int ans = 0;
        while(left>=0){
            if(nums[right]>=2*nums[left]){
                right --;
                ans += 2;
            }
            left--;
        }
        return ans >= mid;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right;
        if((nums.length&1)==1){
            right = nums.length;
        }else {
            right = nums.length+1;
        }
        while (left+1 < right) {
            int mid = (left+right)>>>1;
            if(check(nums,mid)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {57,40,57,51,90,51,68,100,24,39,11,85,2,22,67,29,74,82,10,96,14,35,25,76,26,54,29,44,63,49,73,50,95,89,43,62,24,88,88,36,6,16,14,2,42,42,60,25,4,58,23,22,27,26,3,79,64,20,92};
        System.out.println(new MaxNumOfMarkedIndices2576().maxNumOfMarkedIndices(nums));
    }
}
