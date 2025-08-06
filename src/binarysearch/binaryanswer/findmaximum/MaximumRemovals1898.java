package binarysearch.binaryanswer.findmaximum;

/**
 * @author Canyon
 * @date 2025/07/29
 */
public class MaximumRemovals1898 {
    /**
     * 之前的想法是按部就班的将s中对应的索引删除在进行比较，但是循环删除索引在字符串拼接方面有大量消耗
     * 巧解就是先将字符串转为字符数组(对字符串的操作都尽量转换，用空间换时间)
     * 将需要删除的索引替换成无效字符，之后在进行双指针的比较
     * @param mid 二分决定的可删除的个数
     * @param removable 数组内容对应的主串的索引
     * @param s 主字符串
     * @param p 主字符串的子序列
     * @return boolean 判断删除mid个removable对应的索引之后，p是否还是s的子序列
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
     * 考虑最终的结果从0到全部的removable都有可能
     * left设为0，right设为removable的length+1
     * @param s 主字符串
     * @param p 主字符串的子序列
     * @param removable 数组内容对应的主串的索引
     * @return int 保证p是s的子序列前提下最多可删除的removable前k个索引
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
