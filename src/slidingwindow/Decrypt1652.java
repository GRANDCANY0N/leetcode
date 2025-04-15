package slidingwindow;

import java.util.Arrays;

/**
 * @author Canyon
 */
public class Decrypt1652 {
    /**
     * 依据k的值，决定从倒数第二个数据还是第二个数开始滑动，拆分为两个循环，
     * 第一个循环结束还剩下k个值没有加上，此时sum中还含有之前的和，只需要从头(尾)开始遍历k个数完成剩下的和即可
     * @param code 原数组
     * @param k 滑动窗口的长度以及滑动窗口的方向
     * @return 返回每个值 k方向k个数的和的数组
     */
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] arr = new int[len];
        int sum = 0;
        if(k==0){
            Arrays.fill(arr,0);
            return arr;
        }else if(k>0){
            for (int i = 1; i < len; i++) {
                sum += code[i];
                if(i<k){
                    continue;
                }
                arr[i-k] = sum;
                sum -= code[i-k+1];
            }
            int index = len-k;
            for(int j = 0;j < k;j++){
                sum += code[j];
                arr[index++] = sum;
                if(index == len){
                    break;
                }
                sum -= code[index];
            }
        }else {
            for (int i = len-2; i >= 0; i--) {
                sum += code[i];
                if(i>k+len-1){
                    continue;
                }
                arr[i-k] = sum;
                sum -= code[i-k-1];
            }
            int index = Math.abs(k)-1;
            for(int j = len - 1;j >= len+k; j--){
                sum += code[j];
                arr[index--] = sum;
                if(index<0){
                    break;
                }
                sum -= code[index];
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr =  {10,5,7,7,3,2,10,3,6,9,1,6};
        int[] nums = new Decrypt1652().decrypt(arr, -4);
        for (int num : nums) {
            System.out.print(num+ " ");
        }
    }
}
