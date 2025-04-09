package dailyCode;

public class maxScore_1422 {
    public int maxScore(String s) {
        int leftScore = -1;int allScore = 0;
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if(c=='1'){
                allScore++;
            }
        }
        int maxScore = 0;
        for (int i = 0; i < ch.length-1; i++) {
            if(ch[i]=='0'){
                leftScore++;
            }else {
                allScore--;
            }
            maxScore = Math.max(leftScore+allScore,maxScore);
        }
        return maxScore;
    }
}
