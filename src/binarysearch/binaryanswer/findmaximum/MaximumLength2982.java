package binarysearch.binaryanswer.findmaximum;

import java.util.*;

/**
 * @author Canyon
 * @date 2025/07/28
 */
public class MaximumLength2982 {
    /**
     * 不用二分的方法，分类讨论
     * 将每个字符的出现长度进行统计 例如aabbcca，a字符的出现长度为[2,1],b字符的出现长度为[2],c字符的出现长度为[2]，倒序排列
     * 讨论三种情况
     * 第一种是同一字符出现长度最长的减2 例如aaaa
     * 第二种是从最长和第二长的子串中取最长的减1和第二长的较小值，例如aabbaa和aaba，a的列表分别为[2,2],[2,1]，但是符合条件的只有长度为1的时候
     * 第三种就是最长、次长、第三长的的特殊子串（a[0],a[1],a[2]）中各取一个长为 a[2] 的特殊子串
     * 取这三种情况的最大值
     * @param s 字符串
     * @return int 返回只包含同一字符且出现次数大于等于3次的最长子串
     */
    public int maximumLength(String s) {
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            cnt++;
            if(i+1==chars.length||chars[i]!=chars[i+1]){
                groups[chars[i]-'a'].add(cnt);
                cnt=0;
            }
        }
        int ans = 0;
        for (List<Integer> group : groups) {
            if(group.isEmpty()){
                continue;
            }
            group.sort(Collections.reverseOrder());
            group.add(0);
            group.add(0);
            ans = Math.max(ans,Math.max(group.get(0)-2,Math.max(Math.min(group.get(0) -1, group.get(1)), group.get(2))));
        }
        return ans>0?ans:-1;
    }

    public static void main(String[] args) {
        String s = "abcaba";
        System.out.println(new MaximumLength2982().maximumLength(s));
    }
}
