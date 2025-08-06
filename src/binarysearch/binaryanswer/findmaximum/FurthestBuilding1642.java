package binarysearch.binaryanswer.findmaximum;

import java.util.Arrays;

/**
 * @author Canyon
 * @date 2025/07/31
 */
public class FurthestBuilding1642 {

    /**
     * 首先获取每个建筑物之间的高度差数组，只关注大于0的高度差
     * 由于最终返回的是索引，索引的范围是[0,height.length-1]
     * left设为0，right设为height.length
     * @param heights 建筑物的高度数组
     * @param bricks 砖块数量
     * @param ladders 梯子数量
     * @return int 使用梯子和砖块可以达到的最高的建筑物索引
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        int[] ints = new int[len];
        for (int i = 1; i < len; i++) {
            ints[i] = heights[i]- heights[i-1];
        }
        if(ladders >= len - 1) {
            return len - 1;
        }
        ints[0] = 0;
        int left = 0;
        int right = len;
        while(left+1<right){
            int mid = (left+right)>>1;
            if(check(mid,ints,bricks,ladders)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 整体思路是用一个新的数组截取heights中从[0,mid]的部分
     * 之后对这一部分进行排序，对最高的部分用梯子，剩余部分使用砖块
     * 砖块有剩余或者正好用完说明该索引可以达到，反之则达不到
     * @param mid 二分给定的索引
     * @param heights 建筑物的高度数组
     * @param bricks 砖块数量
     * @param ladders 梯子数量
     * @return boolean 判断是否能达到mid索引处，能达到返回true，否则返回false
     */
    public boolean check(int mid,int[] heights, int bricks, int ladders){
        int[] arr = new int[mid+1];
        System.arraycopy(heights, 0, arr, 0, arr.length);
        Arrays.sort(arr);
        for (int i = arr.length - 1-ladders; i >= 0; i--) {
            if(arr[i]<=0){
                break;
            }
            bricks -= arr[i];
        }
        return bricks>=0;
    }

    public static void main(String[] args) {
        int[]  arr = {4,2,7,6,9,14,12};
        System.out.println(new FurthestBuilding1642().furthestBuilding(arr,5,1));
    }
}
