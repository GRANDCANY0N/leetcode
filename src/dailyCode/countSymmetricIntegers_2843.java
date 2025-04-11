package dailyCode;

public class countSymmetricIntegers_2843 {
    /**
     * 判断[low,high]区间里的左半部分与右半部分的ASCII码值是否相等
     * @param low 低位区间
     * @param high 高位区间
     * @return 合格数的个数
     */
    //通用写法
    public int countSymmetricIntegersTwo(int low, int high) {
        int num = 0;
        for (int i = low; i <= high; i++) {
            char[] ch = Integer.toString(i).toCharArray();
            if(ch.length%2!=0){
                continue;
            }
            int index = 0;
            int sum = 0;
            while(index < ch.length){
                if(index < ch.length/2){
                    sum += ch[index];
                }else {
                    sum -=ch [index];
                }
                index ++;
            }
            if(sum==0){
                num++;
            }
        }
        return num;
    }
    //按照题目要求定制的写法
    public int countSymmetricIntegers(int low, int high) {
        int ant = 0;
        for (int i = low; i <= high; i++) {
            if (numLength(i)==2){
                if(i/10==i%10){
                    ant++;
                }
            }
            else if (numLength(i)==4){
                if((i%1000/100+i/1000)==(i%100/10+i%10)){
                    ant++;
                }
            }
        }
        return ant;
    }
    public int numLength(int num){
        int count = 1;
        while (num >= 10) {
            num /= 10;
            count++;
        }
        return count;

    }
}
