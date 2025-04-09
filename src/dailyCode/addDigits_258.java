package dailyCode;

public class addDigits_258 {
    public int addDigits(int num) {
        if(num < 10){
            return num;
        }
        int sum = mod10(num);
        while (sum>=10){
            sum = mod10(sum);
        }
        return sum;

    }
    public int mod10(int num){
        if(num < 10){
            return num;
        }
        return mod10(num / 10) +num%10;
    }

    public static void main(String[] args) {
        addDigits_258 addDigits258 = new addDigits_258();
        System.out.println(addDigits258.addDigits(666));

    }
}
