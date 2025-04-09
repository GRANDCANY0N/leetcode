package dailyCode;

public class diagonalPrime_2614 {
    public int diagonalPrime(int[][] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i][i] > max && PrimeNum(nums[i][i])){
                max = nums[i][i];
            }
            if(nums[i][nums.length-1-i] > max && PrimeNum(nums[i][nums.length-1-i])){
                max = nums[i][nums.length-1-i];
            }
        }
        return max;
    }
    public boolean PrimeNum(int num){
        double sq = Math.sqrt(num);
        sq = (int) sq;
        for (int i = 2; i <= sq; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return num >=2;
    }

    public static void main(String[] args) {
        diagonalPrime_2614 diagonalPrime2614 = new diagonalPrime_2614();
        int[][] nums = {{503,2,841},{5,937,7},{9,11,10}};
        System.out.println(diagonalPrime2614.diagonalPrime(nums));
    }
}
