package binarysearch.binaryanswer.findminimum;

/**
 * @author canyon
 * @date 2025/07/16
 */
public class SeparateSquares3453 {
    /**
     * 计算所有正方形在大于等于y坐标为mid的面积
     * 首先排除底部坐标加边长小于mid的正方形
     * 其次分两种情况，若正方形被mid拦截和正方形在mid之上，依次计算面积
     * 若mid之上的面积大于所有正方形面积的一半，说明需要将mid向上移，否则mid还可以向下移
     * @param squares squares[i] = [xi, yi, li] 表示一个与 x 轴平行的正方形的左下角坐标和正方形的边长
     * @param mid 二分得出的y轴高度
     * @param sq 所有正方形面积的一半
     * @return boolean 判断在给定mid下，mid上部大于sq返回false，否则返回true
     */
    public boolean check(int[][] squares,double mid, double sq){
        double sqTop = 0;
        for (int[] square : squares) {
            double bottom = square[1];
            double size = square[2];
            double top = bottom + size;
            if(top <= mid){
                continue;
            }
            if(bottom >= mid){
                sqTop += size*size;
            }else {
                sqTop += (top - mid)*size;
            }
            if(sqTop>sq){
                return false;
            }
        }
        return true;
    }

    /**
     * 先确定left和right
     * 考虑y坐标大于等于0，left设置为0，right设为最上面的一个正方形的最高的y坐标，在此范围考虑二分
     * 由于是浮点二分，给定的是1e-5的误差，计算出需要47次循环可以排除这个误差
     * @param squares squares[i] = [xi, yi, li] 表示一个与 x 轴平行的正方形的左下角坐标和正方形的边长
     * @return double 返回最小的 y 坐标 该线需要满足它以上正方形的总面积 等于 该线以下正方形的总面积
     */
    public double separateSquares(int[][] squares) {
        double left = 0;
        long sum = 0;
        double right = 2;
        for (int[] square : squares) {
            right = Math.max(right, square[1]+square[2]);
            sum += (long) square[2] *square[2];
        }
        double sq = (double)sum/2;
        while (left+0.00001 < right) {
            double mid = (left + right)/2;
            if(check(squares, mid, sq)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[][] squares = new int[][]{{0,0,1},{2,2,1}};
        System.out.println(new SeparateSquares3453().separateSquares(squares));
    }
}
