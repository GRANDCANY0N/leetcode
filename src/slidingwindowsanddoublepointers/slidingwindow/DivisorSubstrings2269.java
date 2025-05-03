package slidingwindowsanddoublepointers.slidingwindow;

/**
 * @author Canyon
 */
public class DivisorSubstrings2269 {
    /**
     * 每次滑动完成之后转为int计算是否整除num，注意sb的deleteCharAt方法
     * @param num 原数
     * @param k 滑动窗口的长度
     * @return 返回k个滑动窗口的数能否整除原num的个数
     */
    public int divisorSubstrings(int num, int k) {
        String str  = Integer.toString(num);
        char[] ch = str.toCharArray();
        int ant = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
            if(i<k-1){
                continue;
            }
            int subNum = Integer.parseInt(sb.toString());
            if (subNum!=0 &&num % subNum == 0) {
                ant++;
            }
            sb.deleteCharAt(0);
        }
        return ant;
    }

    public static void main(String[] args) {
        System.out.println(new DivisorSubstrings2269().divisorSubstrings(430043,2));
    }

}
