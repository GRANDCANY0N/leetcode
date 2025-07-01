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
     * @param arr
     * @return int
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
        int endB = upperBound(arr,arr[b]+1,-1,a+1);
        if((endB-startB)>target){
            return arr[b];
        }
        int startC = upperBound(arr,arr[c],a-1,length);
        int endC = upperBound(arr,arr[c]+1,a-1,length);
        if((endC-startC)>target){
            return arr[c];
        }
        return arr[a];
    }
}
