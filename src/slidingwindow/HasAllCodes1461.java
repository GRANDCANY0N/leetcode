package slidingwindow;

import java.util.HashSet;

/**
 * @author Canyon
 */
public class HasAllCodes1461 {
    /**
     * 用set记录所有k位数二进制的不同写法
     * 如果set的size等于2的k次方，说明所有写法都存在 否则不存在
     * @param s 条件字符串
     * @param k 要求满足k位数2进制的不同写法的个数
     * @return boolean
     */
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
            if(i<k-1){
                continue;
            }
            set.add(sb.toString());
            if(set.size()==Math.pow(2,k)){
                return true;
            }
            sb.deleteCharAt(0);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "0110";
        System.out.println(new HasAllCodes1461().hasAllCodes(s,1));
    }
}
