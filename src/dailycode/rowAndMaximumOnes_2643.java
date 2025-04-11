package dailycode;

import java.util.HashMap;

public class rowAndMaximumOnes_2643 {
    public int[] rowAndMaximumOnes(int[][] mat){
        int keyMin = 0;
        int valueMax = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==1){
                    sum++;
                }
            }
            if(sum > valueMax){
                keyMin = i;
                valueMax = sum;
            }
        }
//        int keyMin = 0;
//        int valueMax = 0;
//        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//            if(entry.getValue()>valueMax){
//                valueMax = entry.getValue();
//                keyMin = entry.getKey();
//            }
//            if(entry.getValue()==valueMax){
//                keyMin = entry.getKey();
//            }
//        }
        return new int[]{keyMin,valueMax};
    }

    public static void main(String[] args) {
        rowAndMaximumOnes_2643 rowAndMaximumOnes2643 = new rowAndMaximumOnes_2643();
        int[][] mat = {{0},{0},{1},{1},{1},{1},{0},{0},{0},{1},{0},{0},{0},{0},{1},{1},{1}};
        rowAndMaximumOnes2643.rowAndMaximumOnes(mat);
    }
}
