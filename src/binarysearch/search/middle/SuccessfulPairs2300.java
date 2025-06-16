package binarysearch.search.middle;

import binarysearch.search.helper.GenericBinarySearchHelper;

import java.util.Arrays;

/**
 * @author Canyon
 */
public class SuccessfulPairs2300 extends GenericBinarySearchHelper<Integer> {
    /**
     * 由于是泛型，所以具体的继承要重写为对应的类型比较
     *
     * @param value  数组中的值
     * @param target 目标值
     * @return boolean 比较方法
     */
    @Override
    protected boolean compare(Integer value, Integer target) {
        return value < target;
    }

    /**
     * 先将potions排序
     * 判断success是否整除spell[i]，整除则是大于等于target，不整除则是大于target
     * 时间复杂度 O((n+m)*logM) 空间复杂度O(1)
     * @param spells 将potions的数乘以spell[i]
     * @param potions 数字数组，未排序
     * @param success 目标值
     * @return {@link int[] }
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        Integer[] arr = Arrays.stream(potions).boxed().toArray(Integer[]::new);
        int lengths = potions.length;
        for (int i = 0; i < spells.length; i++) {
            if(success%spells[i]==0){
                spells[i] = lengths - lowerBound(arr,(int)(success/spells[i]));
            }else {
                spells[i] = lengths - lowerBound(arr,(int)(success/spells[i]+1));
            }
        }
        return spells;
    }

    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        System.out.println(Arrays.toString(new SuccessfulPairs2300().successfulPairs(spells, potions, 7)));
    }
}
