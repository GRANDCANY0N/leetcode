package binarysearch.search.extension;

/**
 * @author canyon
 * @date 2025/07/01
 */
public class FindSpecialInteger1287 {
    public int upperBound(int[] arr,int target, int left, int right){
        while(left+1<right){
            int mid = (left+right)>>>1;
            if(arr[mid]<target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }

    /**
     * 考虑这个值至少会出现在1/4，2/4，3/4任意一处
     * 分别将大于等于1/4，2/4，3/4索引的值和小于1/4，2/4，3/4索引的值+1作为target进行二分
     * 如果endA-startA的长度大于数组长度的1/4则arr[a]就是要找的值
     * @param arr 有序数组
     * @return int 数组中有一个值的出现次数超过数组长度的25%，返回这个值
     */
    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int target = length/4;
        int a = (length)/2;
        int b = (a)/2;
        int c = (a+length)/2;
        if(arr[a]==arr[b]){
            return arr[a];
        }else if(arr[b]==arr[c]){
            return arr[b];
        }
        int startB = upperBound(arr,arr[b],-1,a+1);
        if(arr[startB+target]==arr[startB]){
            return arr[b];
        }
        int startC = upperBound(arr,arr[c],a-1,length);
        if(arr[startC+target]==arr[startC]){
            return arr[c];
        }
        return arr[a];
    }

    /**
     * 方法二：
     * 因为数组中有且仅有一个值的出现次数超过数组长度的25%，当两个索引之间差等于数组长度1/4值还相等则就是这个值
     */
    public int findSpecialIntegerTwo(int[] arr) {
        int length = arr.length;
        int a = length/4;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if(i<a-1){
                ans = arr[i];
                continue;
            }
            if(arr[i-a]==arr[i]){
                return arr[i];
            }
        }
        return ans;
    }
}
