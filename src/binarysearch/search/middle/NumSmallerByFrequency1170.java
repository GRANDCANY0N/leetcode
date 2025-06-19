package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

/**
 * @author canyon
 * @date 2025/06/19
 */
public class NumSmallerByFrequency1170 extends GenericBinarySearchHelper<Integer> {
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value < target;
    }

    /**
     * 先找到每个数组中的每个字符串的最小字符的出现次数
     * 统计好之后将word排序，将queries中的数作为target
     * 找到大于target的索引，用words.length-start
     * 空间复杂度(n+m) 时间复杂度(nlogM)
     * @param queries 字符串数组
     * @param words 字符串数组
     * @return {@link int[] } 返回words 中满足 f(queries[i]) < f(W) 的 词的数目
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int queriesLen = queries.length;int wordsLen = words.length;
        int[] cnt1 = new int[queriesLen];
        int[] cnt2 = new int[wordsLen];
        for (int i = 0; i < queriesLen; i++) {
            cnt1[i] = countSmallChar(queries[i]);
        }
        for (int i = 0; i < wordsLen; i++) {
            cnt2[i] = countSmallChar(words[i]);
        }
        Arrays.sort(cnt2);
        Integer[] array = Arrays.stream(cnt2).boxed().toArray(Integer[]::new);
        for (int i = 0; i < queriesLen; i++) {
            cnt1[i] = wordsLen-lowerBound(array,cnt1[i]+1);
        }
        return cnt1;
    }

    public int countSmallChar(String s){
        char[] chars = s.toCharArray();
        int max = 1;
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]<prev){
                max = 1;
                prev = chars[i];
            }else if(chars[i]==prev){
                max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] queries = {"bbb","cc"};
        String[] words  = {"a","aa","aaa","aaaa"};
        NumSmallerByFrequency1170 numSmallerByFrequency1170 = new NumSmallerByFrequency1170();
        System.out.println(Arrays.toString(numSmallerByFrequency1170.numSmallerByFrequency(queries, words)));
    }

}
