package slidingwindowsanddoublepointers.slidingwindow;

/**
 * @author Canyon
 */
public class MaxSatisfied1052 {
    /**
     * 先计算出窗口内能改变获得的最大满意人数（grumpy[i]==1的时最大人数），在遍历grumpy[i]==0+上窗口内的人数
     * @param customers 第i时的顾客人数customers[i]
     * @param grumpy 第i时老板的状态，0表示不生气，1表示生气
     * @param minutes 老板可以连续不生气的长度
     * @return 最大顾客满意的人数
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sat = 0;int maxSat = 0;int index=0;
        for (int i = 0; i < customers.length; i++) {
            if(grumpy[i]==1){
                sat += customers[i];
            }
            if(i<minutes-1){
                continue;
            }
            if(maxSat<=sat){
                maxSat=sat;
                index = i-minutes+1;
            }
            if(grumpy[i-minutes+1]==1){
                sat -= customers[i-minutes+1];
            }
        }
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if(i==index){
                for (int j = 0; j < minutes; j++) {
                    sum+=customers[i++];
                }
            }
            if(i < customers.length&&grumpy[i]==0){
                sum += customers[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {4,10,10};
        int[] nums = {1,1,0};
        System.out.println(new MaxSatisfied1052().maxSatisfied(arr, nums, 2));
    }
}
