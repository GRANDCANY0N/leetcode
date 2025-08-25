package datastructure.enumtech.enumrmaintainl.base;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author canyon
 * @date 2025/08/14
 */
public class InterchangeableRectangles2001 {
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
     * 初步思路：
     * 用double类型作key，直接存储大值/小值的商，相同则说明可以互换
     * 问题出在：值变大以后，分数即使一样但是小数不一样会造成出错，所以存分数是最稳妥的
     * -
     * 整体思路：
     * HashMap存储分子分母最简式和出现的次数
     * 每次ans先加此次分子分母最简式的出现次数再更新出现次数
     * -
     * 注：
     * containsKey的底层是先根据hashCode找到对应的桶，之后进行equal
     * 用HashMap<int[], Integer>的问题出现在，每次new一个int[]对象，hashCode是不一样的
     * 因此重新写一个Rectangle类重写hashCode生成方法确保值相同的hashCode相同
     * -
     * 步骤：
     * 新建类Rectangle存储最简化的分子分母和出现次数
     * 循环遍历数组，先计算两条边的最大公约数，将width和height除以最大公约数后判断当前是否存在此最简分子式
     * 存在则ans加上当前的出现次数，之后更新hashMap
     * -
     * 复杂度：
     * - 时间复杂度： O(N) 一次遍历
     * - 空间复杂度： O(N) 开辟hashMap
     * @param rectangles 矩阵二维数组
     * @return long
     */
    public long interchangeableRectangles(int[][] rectangles) {
        long ans = 0;
        HashMap<Rectangle, Integer> map = new HashMap<>(16);
        for (int[] arr : rectangles) {
            int width = arr[0];
            int height = arr[1];
            int gcd = gcd(width, height);
            Rectangle rectangle = new Rectangle(width/gcd, height/gcd);
            int count = map.getOrDefault(rectangle, 0);
            ans += count;
            map.put(rectangle, count + 1);
        }
        return ans;
    }

    /**
     * 欧几里得算法
     * 辗转相除法求最大公约数
     * @param a 参数a
     * @param b 参数b
     * @return int 返回a和b的最大公约数
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] rectangles = new int[][]{{4,8},{3,6}};
        System.out.println(new InterchangeableRectangles2001().interchangeableRectangles(rectangles));
    }
}
