package dailycode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Canyon
 */
public class Candy135 {

    public static int candy(int[] ratings) {
        int len = ratings.length;
        int sum = 0;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return 1;
        }
        int[] ar = new int[len];
        Arrays.fill(ar,1);
        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i+1] > ratings[i]){
                ar[i+1] = Math.max(ar[i]+1, ar[i]);
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if(ratings[i-1] > ratings[i]){
                ar[i-1] = Math.max(ar[i]+1, ar[i-1]);
            }
        }

//        int[] res = minIndex(ratings);
//        for (int re : res) {
//            if(re==0){
//                if(ratings[re] > ratings[re+1] && ar[re] <= ar[re+1]){
//                    ar[re] = ar[re+1] + 1;
//                }
//            } else if (re == len-1) {
//                if(ratings[re] > ratings[re-1] && ar[re] <= ar[re-1]){
//                    ar[re] = ar[re-1] + 1;
//                }
//            }else {
//                if(ratings[re]>ratings[re+1]&&ar[re]<=ar[re+1]){
//                    ar[re] = ar[re+1] +1;
//                }else if ((ar[re]<=ar[re-1] && ratings[re]>ratings[re-1])){
//                    ar[re] = ar[re-1] +1;
//                }
//                if(ratings[re] < ratings[re-1]){
//                    ar[re-1] = ar[re]+1;
//                }
//                if(ratings[re] < ratings[re+1]){
//                    ar[re+1] = ar[re]+1;
//                }
//            }
//        }

        sum = IntStream.of(ar).sum();
        return sum;

    }


    public static int[] minIndex(int[] ratings) {
        int len = ratings.length;
        Integer[] indices = new Integer[len];

        // 初始化索引数组
        for (int i = 0; i < len; i++) {
            indices[i] = i;
        }

        // 按照 ratings 值对索引数组排序
        Arrays.sort(indices, (i, j) -> Integer.compare(ratings[i], ratings[j]));

        // 转换为 int[]
        int[] sortedIndices = new int[len];
        for (int i = 0; i < len; i++) {
            sortedIndices[i] = indices[i];
        }

        return sortedIndices;
    }


    public static void main(String[] args) {
        int[] ratings = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
        System.out.println(candy(ratings));

    }
}


