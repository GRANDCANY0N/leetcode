package binarysearch.search.base;

import binarysearch.search.helper.GenericBinarySearchHelper;


public class NextGreatestLetter744 extends GenericBinarySearchHelper<Character> {
    @Override
    protected boolean compare(Character value, Character target) {
        return value < target;
    }
    /**
     * 大于target 采用 lower_bound(nums, target+1)
     * 只需要找到这个索引即可 不用管索引的具体值
     * 考虑right不变则全部都小于target+1，不存在这样的数
     * @param letters 字符数组
     * @param target 目标值
     * @return char 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符
     */
    public char nextGreatestLetter(char[] letters, char target) {
        Character[] characters = new Character[letters.length];
        for (int i = 0; i < letters.length; i++) {
            characters[i] = letters[i];
        }
        target = (char)(target+1);
        int start = lowerBound(characters,target);
        return start==letters.length ? letters[0] : letters[start];
    }

    public static void main(String[] args) {
        char[] ch = {'c','g','s','t'};
        NextGreatestLetter744 nextGreatestLetter744 = new NextGreatestLetter744();
        System.out.println(nextGreatestLetter744.nextGreatestLetter(ch,'z'));
    }

}
