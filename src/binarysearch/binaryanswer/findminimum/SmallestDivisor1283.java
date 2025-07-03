package binarysearch.binaryanswer.findminimum;

/**
 * @author Canyon
 * @date 2025/07/03
 */
public class SmallestDivisor1283 {


    /**
     * 相较于原方法，将检验的部分提炼出check函数，并且如果sum > threshold 就提前结束
     * @param nums 需要进行除法的数组
     * @param mid 用来二分的中间值
     * @param threshold 门槛值
     * @return boolean
     */
    public boolean check(int[] nums, int mid, int threshold){
        int sum = 0;
        for (int num : nums) {
            sum += (num+mid-1)/mid;
            if(sum > threshold){
                return  false;
            }
        }
        return true;
    }
    /**
     * 先找到threshold和nums中最大值二者比较的较大值作为threshold
     * （为什么不用比较最大值，因为题目条件一定有解，所以即使threshold很大也没关系）
     * 在[0,threshold]之间进行二分，mid = (1+threshold)>>>1
     * 将数组中所有数除以mid，如果小于等于threshold,说明[1,mid]的全部满足条件，现在要找最小的满足条件的数， right = mid
     * 如果大于threshold，说明mid除数太小，需要扩大，left = mid
     * @param nums 数字数组
     * @param threshold 门槛值
     * @return int 找到一个最小的数ans，数组中所有的数除以ans的向上取整的和要小于threshold
     */

    public int smallestDivisor(int[] nums, int threshold) {
        int right = 0;
        int left = 0;
        for (int num : nums) {
            right = Math.max(num,right);
        }
        while(left+1<right){
            int mid = (left+right)>>>1;
            if(check(nums,mid,threshold)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        System.out.println(new SmallestDivisor1283().smallestDivisor(arr,6));
    }
}
