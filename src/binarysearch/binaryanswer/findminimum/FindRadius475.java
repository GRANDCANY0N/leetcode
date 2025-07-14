package binarysearch.binaryanswer.findminimum;


import java.util.Arrays;

/**
 * @author Canyon
 * @date 2025/07/11
 */
public class FindRadius475 {
    /**
     * 遍历房屋数组，循环的含义是看每个房屋是不是可以被覆盖
     * 首先考虑房屋左边，如果heaters[j]+mid达不到房屋的位置，说明取暖器位置不够，移动取暖器
     * 如果j达到极限依旧没有达到直接返回false，说明范围不够大
     * 此时heaters[j]一定会在从houses[i]-mid开始右边的位置，需要判断houses[i]是不是在[heaters[j]-mid,heaters[j]+mid]这个范围里
     * 在就下一个房屋如法炮制，出现一个房屋不在则说明无法完全覆盖，需要增大半径返回false，遍历完整返回true
     * @param houses 一条水平线上的房屋数组
     * @param heaters 供暖器数组
     * @param mid 二分得到的取暖半径
     * @return boolean
     */
    public boolean check(int[] houses, int[] heaters, int mid){
        int m = heaters.length;
        int j = 0;
        for (int house : houses) {
            while (j < m && house > heaters[j] + mid) {
                j++;
            }
            if (j < m && Math.abs(heaters[j] - house) <= mid) {
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 先对两个数组排序
     * 可能出现供暖器和房屋位置一样，最低的范围为0，将left设为-1，right为两个数组中的最大值
     * @param houses 一条水平线上的房屋数组
     * @param heaters 供暖器数组
     * @return int
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int left = -1;
        int right = Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        while(left+1 < right){
            int mid = (left+right)>>>1;
            if(check(houses,heaters,mid)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        System.out.println(new FindRadius475().findRadius(houses,heaters));
    }
}
