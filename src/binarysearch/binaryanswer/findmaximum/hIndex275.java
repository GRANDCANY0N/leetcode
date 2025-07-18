package binarysearch.binaryanswer.findmaximum;

public class hIndex275 {

    /**
     * 由于数组非降序排序，只需要考虑数组的倒数第target篇论文的引用次数是否大于等于target
     * 大于等于返回true 否则返回false
     * @param citations 研究者的第 i 篇论文被引用的次数 非降序排列
     * @param target 二分给定的论文篇数的引用次数
     * @return boolean 返回是否有target篇论文满足target引用次数
     */
    public boolean check(int[] citations, int target){
        return citations[citations.length-target]>=target;

    }

    /**
     * 至少的最多二分，从左边开始二分
     * 最好情况是所有论文的引用次数都大于等于最后一篇论文的引用次数，最差情况是没有一篇论文的引用超过第一篇引用
     * 开区间范围就能找到(0,citations.length+1)
     * 与lower_bound不一样的是，这是从左边收缩的二分，check返回true此时的mid至少可以满足条件，在此时的left基础上去找更大的答案
     * 所以返回left
     * @param citations 研究者的第 i 篇论文被引用的次数 非降序排列
     * @return int 返回至少 有 h 篇论文分别被引用了至少 h 次
     */
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length+1;
        while(left+1  <right){
            int mid = (left + right)>>1;
            if(check(citations,mid)){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};
        System.out.println(new hIndex275().hIndex(citations));
    }
}
