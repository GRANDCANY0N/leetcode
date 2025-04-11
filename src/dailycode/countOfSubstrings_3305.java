package dailycode;

import java.util.Arrays;

public class countOfSubstrings_3305 {
    public static int countOfSubstrings(String word, int k) {
        int len = word.length();
        int sum = 0;
        if (len < 5) {
            return 0;
        }

        for (int i = 0; i <= word.length()-(k+5); i++) {

            for (int initWin = i+5+k;initWin<=word.length();initWin++){
                if(counting(word.substring(i,initWin),k)){
                    sum++;
                }
            }

        }
        return sum;
    }

    public static boolean counting(String word, int k){
        int[] substring = new int[5];
        Arrays.fill(substring, 0);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            switch (ch) {
                case 'a' -> substring[0]++;
                case 'e' -> substring[1]++;
                case 'i' -> substring[2]++;
                case 'o' -> substring[3]++;
                case 'u' -> substring[4]++;
            }
        }

        for (int j : substring) {
            if (j == 0) {
                return false;
            }
        }
        int sum = Arrays.stream(substring).sum();
        return (sum + k) == word.length();
    }

    public static void main(String[] args) {
        String word = "iqeaouqi";
        System.out.println(countOfSubstrings(word,2));
    }
}
