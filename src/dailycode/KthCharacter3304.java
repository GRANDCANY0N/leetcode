package dailycode;

/**
 * @author Canyon
 * @date 2025/07/08
 */
public class KthCharacter3304 {
    /**
     * 从k个字符开始找前身，先找到k大于最大的2的指数值，依次用k减去k大于的2的指数值，直至k等于1
     * 最终的结果就是减去的次数+'a'
     * @param k 至少的数组长度
     * @return char 复制数组后第k个字符
     */
    public char kthCharacter(int k) {
        if(k==1){
            return 'a';
        }
        int i = 1;
        int ans = 0;
        while(k>i){
            i*=2;
        }
        while(true){
            if(i>=k){
                i/=2;
                continue;
            }
            k-=i;
            ans++;
            if(k==1){
                break;
            }
        }
        return (char)('a'+ans);
    }
}
