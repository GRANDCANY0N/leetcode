package dailycode;

import java.util.*;

public class sortMatrix_3446 {
    public int[][] sortMatrix(int[][] grid){
        int row = grid.length; int column = grid[0].length;
        int[][] ints = new int[row][column];
        for(int k=1;k<column+row;k++){
            List<Integer> list = new ArrayList<>();
            int minJ = Math.max(column-k,0);
            int maxJ = Math.min(column-k+row-1,column-1);
            for (int j = minJ; j < maxJ+1; j++) {
                list.add(grid[k+j-column][j]);
            }

            if(k <= (column+row)/2){
                list.sort(Comparator.naturalOrder()); // 升序
            }else {
                list.sort(Comparator.reverseOrder()); // 降序
            }
            int index = 0;
            for (int j = minJ; j < maxJ+1; j++) {
                ints[k+j-column][j] = list.get(index++);
            }
        }
        return ints;
    }
}
