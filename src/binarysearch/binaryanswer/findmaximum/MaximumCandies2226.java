package binarysearch.binaryanswer.findmaximum;

/**
 * @author canyon
 * @date 2025/07/18
 */
public class MaximumCandies2226 {
    /**
     * 由于糖果可以分成子堆但是子堆不能合成，用糖果除以糖果数向下取整就是每一堆糖果可以满足的孩子数
     * 如果孩子数大于等于k说明此时的糖果数可以满足孩子 返回true，否则满足不了返回false
     * @param candies 糖果数组  可以将每堆糖果分成任意数量的 子堆
     * @param mid 二分给定的糖果数
     * @param k 孩子数
     * @return boolean 判断每个孩子是否能得到mid个糖果
     */
    public boolean check(int[] candies,int mid, long k){
        long sum = 0;
        for (int candy : candies) {
            sum += candy/mid;
            if(sum >= k){
                return true;
            }
        }
        return false;
    }

    /**
     * 最好情况只有一个孩子，这个孩子可以分得最多一堆糖果
     * 最坏情况孩子数大于糖果数，糖果数不够分
     * 考虑开区间写法，left设为0，right设为每个孩子最多能分到的最大糖果数 + 1
     * 其中每个孩子能分到的最大糖果数，取每堆糖果最大值和糖果总数除以孩子数二者的较小值
     * 例如：一堆里最多只有 7 颗糖，每个孩子理论最多能分的也是 7；但如果总共只有 10 颗糖，5 个孩子，
     * 那每人最多也只能分到 2 颗，因此取两者的最小值，再加 1 构成右边界
     * @param candies 糖果数组  可以将每堆糖果分成任意数量的 子堆
     * @param k 孩子数
     * @return int 最多的每个孩子拿到的糖果数
     */
    public int maximumCandies(int[] candies, long k) {
        int left = 0;
        int right = 0;
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
            right = Math.max(right, candy);
        }
        right = (int) Math.min(right,sum/k)+1;
        while(left+1<right){
            int mid = (left+right)>>1;
            if(check(candies,mid,k)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
