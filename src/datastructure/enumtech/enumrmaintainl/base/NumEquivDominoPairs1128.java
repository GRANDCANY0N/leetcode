package datastructure.enumtech.enumrmaintainl.base;


import java.util.HashMap;

import java.util.Objects;

/**
 * @author canyon
 * @date 2025/08/18
 */
public class NumEquivDominoPairs1128 {
    public static class Rectangle {
        public int x;
        public int y;

        public Rectangle(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null || getClass()!= obj.getClass()) return false;
            Rectangle rectangle = (Rectangle) obj;
            return this.x == rectangle.x && this.y == rectangle.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * 整体思路：
     * 两个值的和与积可以确定唯一的两个值
     * 新建数据结构存储两个值的和与积，如果相等说明可以翻转
     * -
     * 步骤：
     * 新建类Rectangle存储一对(两个)多米诺骨牌的和与积并存到hashMap
     * 判断当前这对多米诺骨牌是否与hashMap中的匹配
     * 存在则ans加上当前的出现次数，之后更新hashMap
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(N) hashMap
     * -
     * @param dominoes 多米诺骨牌数组
     * @return int 返回等价的多米诺骨牌对数
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        HashMap<Rectangle, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            Rectangle rectangle = new Rectangle(domino[0]+domino[1],domino[0]*domino[1]);
            int count = map.getOrDefault(rectangle, 0);
            ans += count;
            map.put(rectangle, count+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] dominoes = new int[][]{{1,2},{2,1}};
        System.out.println(new NumEquivDominoPairs1128().numEquivDominoPairs(dominoes));
    }
}
