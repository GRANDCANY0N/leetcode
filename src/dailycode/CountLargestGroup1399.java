package dailycode;

import java.util.HashMap;

/**
 * @author Canyon
 */
public class CountLargestGroup1399 {
    /**
     * 首先写一个判断各个位数和的方法，循环%10再/10获取各个位数的和
     * hashMap统计每个和出现的次数，如果出现新的次数就将ans置为1，如果与最大次数相同则ans++
     * @param n 约定数字
     * @return 最多出现的和的次数
     */
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 0;int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getDigitSum(i);
            int count = hashMap.merge(sum, 1, Integer::sum);
            if (count > max) {
                max = count;
                ans = 1;
            } else if (count == max) {
                ans++;
            }
        }
        return ans;
    }
    public static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
