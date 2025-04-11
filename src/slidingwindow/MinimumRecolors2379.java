package slidingwindow;

/**
 * @author Canyon
 */
public class MinimumRecolors2379 {
    /**
     * 一个只含W和B的字符串 返回找到长度为k且全为B的最小修改W为B的次数
     * @param blocks 主串
     * @param k 全为B的长度
     * @return 最小次数
     */
    public int minimumRecolors(String blocks, int k) {
        int colorW = 0;
        char[] ch = blocks.toCharArray();
        int min = ch.length;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]=='W'){
                colorW++;
            }
            if(i<k-1){
                continue;
            }
            min = Math.min(min,colorW);
            if(ch[i-k+1]=='W'){
                colorW--;
            }
        }
        return min;

    }
    public static void main(String[] args) {
        String str = "WBBWWBBWBW";
        int i = new MinimumRecolors2379().minimumRecolors(str,7);
        System.out.println(i);
    }
}
