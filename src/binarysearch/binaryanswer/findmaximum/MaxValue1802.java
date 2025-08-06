package binarysearch.binaryanswer.findmaximum;

/**
 * @author Canyon
 * @date 2025/07/30
 */
public class MaxValue1802 {
    /**
     * 能取到的范围为[1,maxSum]
     * left设为1，right设为maxSum+1
     * @param n 数组长度
     * @param index 指定索引
     * @param maxSum 数组所有元素之和不超过 maxSum
     * @return int 满足数组相邻两个值的差不超过1且所有元素之和不超过 maxSum情况下，index能取到的最大值
     */
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        while(left+1<right){
            int mid = (right+left)>>1;
            if(check(mid,n,index,maxSum)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 用sumLeft和sumRight来计算index左边和右边和的情况，会重复一个mid需要减去
     * 左右两边都需要考虑有无多余情况，由于规定必须为正整数，多的部分补充为1
     * 没有多余情况用求和方法即可
     * @param mid 二分给定的index处的值
     * @param n 数组长度
     * @param index 指定索引
     * @param maxSum 数组所有元素之和不超过 maxSum
     * @return boolean 判断index的值为mid时数组之后是否小于等于maxSum
     */
    public boolean check(int mid,int n, int index, int maxSum){
        long sumLeft;
        if (index >= mid) {
            sumLeft = (long) (1 + mid) *mid/2+index-mid+1;
        }else {
            sumLeft = (mid* 2L -index)*(index+1)/2;
        }
        long sumRight;
        long a = n-index-1-mid;
        if(a>=0){
            sumRight = (long) (1 + mid) *mid/2 + a+1;
        }else {
            sumRight = (mid - a) *(n-index)/2;
        }
        return (sumRight+sumLeft-mid)<=maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxValue1802().maxValue(3,0,815094800));
    }

}
