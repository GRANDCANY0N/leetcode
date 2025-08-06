package binarysearch.binaryanswer.findmaximum;

import java.util.HashMap;

/**
 * @author canyon
 * @date 2025/07/23
 */
public class MaximumLength2982 {
    public boolean check(char[] ch, int mid) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < ch.length; right++) {
            if(ch[right] != ch[left]) {
                left = right;
                continue;
            }
            if(right - left +1 == mid) {
                map.merge(ch[left], 1, Integer::sum);
                left++;
            }
            if(map.getOrDefault(ch[right],0)>=3){
                return true;
            }
        }
        return false;
    }
    public int maximumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] charArray = s.toCharArray();
        while(left+1 < right){
            int mid = (left+right)>>1;
            if(check(charArray,mid)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left==0?-1:left;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        MaximumLength2982 max = new MaximumLength2982();
        System.out.println(max.maximumLength(s));
    }
}
