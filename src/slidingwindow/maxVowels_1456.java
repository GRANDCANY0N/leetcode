package slidingWindow;

public class maxVowels_1456 {
    /**
     *
     * @param s 主字符串
     * @param k 滑动窗口个数
     * @return 返回最长的元音字符个数
     * 暴力解法 不通过
     */
    public int maxVowels(String s, int k) {
        char[] ch = s.toCharArray();
        int vowel = 0;
        int ant = 0;
        for (int i = 0; i < ch.length; i++) {
            char in = ch[i];
            if(in=='i'|| in=='a'|| in=='e'|| in=='o'|| in=='u'){
                vowel++;
            }
            if(i<k-1){
                continue;
            }
            ant = Math.max(ant, vowel);
            char out = ch[i-k+1];
            if(out=='i'|| out=='a'|| out=='e'|| out=='o'|| out=='u'){
                vowel--;
            }
        }
        return ant;
    }
    //    public int maxVowels(String s, int k) {
//        int maxScore = 0;
//        for(int i=0;i<s.length();i++){
//            int score = 0;
//            for(int j=i;j<i+k && j<s.length();j++){
//                if(s.charAt(j)=='i'||
//                        s.charAt(j)=='a'||
//                        s.charAt(j)=='e'||
//                        s.charAt(j)=='o'||
//                        s.charAt(j)=='u'){
//                    score++;
//                }
//            }
//            maxScore = Math.max(maxScore, score);
//            if(maxScore==k){
//                return k;
//            }
//        }
//        return maxScore;
//    }
}
