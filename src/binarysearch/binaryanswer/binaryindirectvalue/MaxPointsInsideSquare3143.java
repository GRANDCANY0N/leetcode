package binarysearch.binaryanswer.binaryindirectvalue;

import java.util.Arrays;

/**
 * @author Canyon
 * @date 2025/08/05
 */
public class MaxPointsInsideSquare3143 {
    /**
     * 解法一：维护次小距离的最小值
     * 由于正方形中不可能出现两个相同的点，所以我们需要先找到每个字符的第二小的点的绝对值
     * 再在这些值找到最小的min，此时边长为min-1的正方形的点的个数就是answer
     * @param points 二维坐标数组 points[i] 表示第 i 个点的坐标
     * @param s 字符串 s[i] 表示第 i 个点的 标签
     * @return int 返回合法 正方形中可以包含的 最多 点数
     */
    public int maxPointsInsideSquare(int[][] points, String s) {
        char[] chars = s.toCharArray();
        //维护各个点的最小值
        int[] ints = new int[26];
        Arrays.fill(ints,Integer.MAX_VALUE);
        //各个点的次小值的最小值
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            int a = Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
            int index = chars[i] - 'a';
            if(a<ints[index]){
                secondMin = Math.min(ints[index],secondMin);
                ints[index] = a;
            }else {
                secondMin = Math.min(secondMin,a);
            }
        }
        int ans = 0;
        for (int anInt : ints) {
            if(anInt<secondMin){
                ans++;
            }
        }
        return ans;
    }

    /**
     * 解法二：二分简洁值
     * 选择二分边长长度，找到最合适的边长
     * 最好情况所有点在都在边长为绝对值最大的一个点的正方形中，最坏情况一个都没有
     * 边长范围为[0,max(|points|)],left设为0，right设为max(|points|)+1
     * @param points 二维坐标数组 points[i] 表示第 i 个点的坐标
     * @param s 字符串 s[i] 表示第 i 个点的 标签
     * @return int 返回合法 正方形中可以包含的 最多 点数
     */
    public int maxPointsInsideSquareTwo(int[][] points, String s) {
        int left = 0;
        int right = 0;
        for (int[] point : points) {
            int a = Math.abs(point[0]); int b = Math.abs(point[1]);
            right = Math.max(right,Math.max(a,b))+1;
        }
        char[] chars = s.toCharArray();
        while(left+1<right){
            int mid = (left+right)>>1;
            if(check(points,chars,mid)){
                left = mid;
            }else {
                right = mid;
            }
        }
        int ans = 0;
        for (int[] point : points) {
            if(Math.abs(point[0])<=left&&Math.abs(point[1])<=left){
                ans++;
            }
        }
        return ans;
    }

    /**
     * 用长度为26的数组记录在边长为mid的正方形中的个数，大于等于两个返回false
     * @param points 二维坐标数组 points[i] 表示第 i 个点的坐标
     * @param chars 字符数组 chars[i] 表示第 i 个点的 标签
     * @param mid 二分给定的正方形边长
     * @return boolean 判断在mid边长下是否存在字符相等的两个点
     */
    public boolean check(int[][] points, char[] chars, int mid){
        int[] ints = new int[26];
        for (int i = 0; i < points.length; i++) {
            int a = Math.abs(points[i][0]); int b = Math.abs(points[i][1]);
            a = Math.max(a,b);
            int index = chars[i]-'a';
            if(a<=mid){
                ints[index]++;
            }
            if(ints[index]>=2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{-54,27},{17,39},{26,-57},{-32,-61},{-54,59},{-46,60},{-18,-63},{45,26}};
        System.out.println(new MaxPointsInsideSquare3143().maxPointsInsideSquareTwo(arr,"aebffcee"));
    }
}
