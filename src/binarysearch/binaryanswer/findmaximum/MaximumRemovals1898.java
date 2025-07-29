package binarysearch.binaryanswer.findmaximum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Canyon
 * @date 2025/07/29
 */
public class MaximumRemovals1898 {
    /**
     * @param mid
     * @param removable
     * @param s
     * @param p
     * @return boolean
     */
    public boolean check(int mid,int[] removable,char[] s,char[] p){
        for (int i = 0; i < mid; i++) {
            s[removable[i]]='A';
        }

        int i = 0;
        for (char c : s) {
            if (c == p[i]) {
                i++;
            }
            if (i == p.length) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param s
     * @param p
     * @param removable
     * @return int
     */
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] chars = p.toCharArray();
        int left = 0;
        int right = removable.length+1;
        while(left+1<right){
            int mid = (left+right)>>1;
            if(check(mid,removable,s.toCharArray(),chars)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        String s = "qobftgcueho";
        String p = "obue";
        int[] removable = {5,3,0,6,4,9,10,7,2,8};

        System.out.println(new MaximumRemovals1898().maximumRemovals(s,p,removable));
    }
}
