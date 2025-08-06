package binarysearch.binaryanswer.findmaximum;


/**
 * MGZ TODO 4/8/2025：没做出来的二分
 * @author Canyon
 * @date 2025/08/04
 */
public class FindMaximumNumber3007 {
    public long findMaximumNumber(long k, int x) {
        long totalPrice = 0;
        long index = 0;
        long num = 1;
        while(totalPrice<=k){
            totalPrice += findPrice(num++,x);
            index++;
        }
        return index-1;
    }

    public static int findPrice(long k,int x){
        int price = 0;
        boolean flag = true;
        while(k>0){
            if (flag){
                k = k>>(x-1);
                flag = false;
            }else {
                k = k>>x;
            }
            price += k&1;
        }
        return price;
    }
    public static void main(String[] args) {
        System.out.println(findPrice(6,1));
    }
}
