package dailyCode;

public class subtractProductAndSum_1281 {
    public int subtractProductAndSum(int n){
        String str = Integer.toString(n);
        int multiplication = 1, sum = 0;
        if (str.length() <= 1) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            multiplication *= ((int) str.charAt(i)-48);
            sum += ((int) str.charAt(i)-48);
        }
        return multiplication - sum;
    }

    public static void main(String[] args) {
        subtractProductAndSum_1281 subtractProductAndSum1281 = new subtractProductAndSum_1281();
        System.out.println(subtractProductAndSum1281.subtractProductAndSum(234));
    }
}
