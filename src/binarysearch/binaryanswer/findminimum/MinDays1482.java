package binarysearch.binaryanswer.findminimum;

/**
 * @author Canyon
 * @date 2025/07/14
 */
public class MinDays1482 {
    /**
     * 将j设为起始，每次j+k看作一个组，如果一个组里的都满足小于等于给定天数mid，这个组可以做成一束花，flower++
     * 反之若有一朵花天数不满足，则从这朵花下一朵开始+k看作一个组，继续遍历是否满足
     * 当flower>=m说明天数足够，返回true 反之说明天数不够，返回false
     * @param bloomDay 第 i 朵花会在 bloomDay[i] 时盛开的花朵数组
     * @param mid 二分给出的最小天数
     * @param m 制作 m 束花
     * @param k 需要相邻的k朵花
     * @return boolean
     */
    public boolean check(int[] bloomDay, int mid, int m, int k){
        int flower = 0;
        int j = 0;
        int t = k;
        while (j<bloomDay.length) {
            while(j<bloomDay.length&&j<k&&bloomDay[j]<=mid){
                j++;
            }
            if(j==k){
                flower++;
            }else {
                j++;
            }
            k = j + t;
            if(flower>=m){
                return true;
            }
        }
        return false;
    }

    /**l;'\
     * 如果bloomDay的长度小于m*k，花采不满，返回-1，注意要转为long
     * left设为-1，right设为bloomDay中的最大值
     * @param bloomDay 第 i 朵花会在 bloomDay[i] 时盛开的花朵数组
     * @param m 制作 m 束花
     * @param k 需要相邻的k朵花
     * @return int
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k){
            return -1;
        }
        int left = 0;
        int right = 0;
        for (int i : bloomDay) {
            right = Math.max(right,i);
        }
        while(left+1<right) {
            int mid = (left+right)>>1;
            if(check(bloomDay,mid,m,k)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr ={40,74,42,94,90,9,29,45,32,35,42,71,73,47,49,83,72,64,66,100,31,35,23,24,96,9,71,37,95,26,25,54,65,45,92,88,38,80};
        System.out.println(new MinDays1482().minDays(arr,2,13));
    }
}
