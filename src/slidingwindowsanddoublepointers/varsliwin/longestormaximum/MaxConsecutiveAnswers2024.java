package slidingwindowsanddoublepointers.varsliwin.longestormaximum;

/**
 * @author Canyon
 */
public class MaxConsecutiveAnswers2024 {
    /**
     * MGZ TODO 2025/5/12：待优化，将两个循环转为一个
     */
    /**
     * 分别计算T和F的最长字串，使用sum记录长度，移动left
     * @param answerKey 条件字符串
     * @param k 允许修改字符的个数
     * @return int 最长T子串 或者 最长F子串
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ansT=0;int ansF=0;int sum=0;
        int left = 0;
        char[] ch = answerKey.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]=='T'){
                sum++;
            }
            while(sum>k){
                if(ch[left]=='T'){
                    sum--;
                }
                left++;
            }
            ansT = Math.max(i-left+1,ansT);
        }
        left=0;sum=0;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]=='F'){
                sum++;
            }
            while(sum>k){
                if(ch[left]=='F'){
                    sum--;
                }
                left++;
            }
            ansF = Math.max(i-left+1,ansF);
        }
        return Math.max(ansF,ansT);
    }

    public static void main(String[] args) {
        String answerKey = "TTFTTFTT";
        System.out.println(new MaxConsecutiveAnswers2024().maxConsecutiveAnswers(answerKey,1));
    }
}
