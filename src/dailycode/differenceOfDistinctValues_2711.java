package dailycode;

import java.util.*;

public class differenceOfDistinctValues_2711 {
    public int[][] differenceOfDistinctValues(int[][] grid){
        int row = grid.length;
        int column = grid[0].length;
        int[][] ints = new int[row][column];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                HashSet<Integer> set1 = new HashSet<>();
//                int x = i+1;int y = j+1;
//                while (x<row&&y<column){
//                    set1.add(grid[x][y]);
//                    x++;
//                    y++;
//                }
//                x = i-1; y=j-1;
//                HashSet<Integer> set2 = new HashSet<>();
//                while(x>0&&y>0){
//                    set2.add(grid[x][y]);
//                    x--;
//                    y--;
//                }
//                ints[i][j] = Math.abs(set1.size()-set2.size());
//            }
//        }
        HashSet<Integer> set = new HashSet<>();
        for(int k=1; k<column+row; k++){
            int minJ = Math.max(0, column-k);
            int maxJ = Math.min(column-1,column-k+row-1);
            set.clear();
            for (int j=minJ; j<= maxJ; j++){
                ints[j+k-column][j] = set.size();
                set.add(grid[j+k-column][j]);
            }
            set.clear();
            for (int j=maxJ; j>=minJ; j--){
                ints[j+k-column][j] = Math.abs(ints[j+k-column][j]-set.size());
                set.add(grid[j+k-column][j]);
            }
        }
        return ints;
    }
}
