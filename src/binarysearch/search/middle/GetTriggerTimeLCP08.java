package binarysearch.search.middle;


import java.util.Arrays;

public class GetTriggerTimeLCP08 {

    public static int upperBound(int[][] arr,int target,int i){
        int right  = arr.length;
        int left = -1;
        while(left+1<right){
            int mid = (left+right)>>>1;
            if(arr[mid][i]<target){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
    /**
     * 先将属性按天数全部累加，increase[i]代表的是当前天数对应的属性值，并且由于累加所以有序
     * 根据对应的属性进行二分，分别将大于等于requirements[i][0]、requirements[i][1]、requirements[i][2]作为target进行二分
     * 取其中最高的一个值的索引，此时这个索引满足所有条件。如果有一个等于length则说明有一个无法满足条件。直接返回-1
     * @param increase 属性数组
     * @param requirements 触发剧情所需要的数据数组
     * @return {@link int[] } 按天累加属性数组，当达到触发剧情所需要的数是返回当前天数，否则返回-1，返回所有剧情的一维数组
     */
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }
        int[] arr = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            if(requirements[i][0]==0&&requirements[i][1]==0&&requirements[i][2]==0){
                arr[i] = 0;
                continue;
            }
            int a = upperBound(increase, requirements[i][0], 0);
            if(a==increase.length){
                arr[i] = -1;
                continue;
            }
            int b = upperBound(increase, requirements[i][1], 1);
            if(b==increase.length){
                arr[i] = -1;
                continue;
            }
            int c = upperBound(increase, requirements[i][2], 2);
            if(c==increase.length){
                arr[i] = -1;
                continue;
            }
            arr[i] = Math.max(a,Math.max(b,c))+1;
        }
        return arr;


    }

    public static void main(String[] args) {
        int[][] increase = {
                {2, 8, 4},
                {2, 5, 0},
                {10, 9, 8}
        };

        int[][] requirements = {
                {2, 11, 3},
                {15, 10, 7},
                {9, 17, 12},
                {8, 1, 14}
        };
        System.out.println(Arrays.toString(new GetTriggerTimeLCP08().getTriggerTime(increase, requirements)));
    }
}
