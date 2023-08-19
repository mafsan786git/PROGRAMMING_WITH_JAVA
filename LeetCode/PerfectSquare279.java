import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PerfectSquare279 {

    /**
     * Given an integer n, return the least number of perfect square numbers that sum to n.
        A perfect square is an integer that is the square of an integer;
        in other words, it is the product of some integer with itself. For example, 1, 4, 9, 
        and 16 are perfect squares while 3 and 11 are not.
     * dp[1] = 1
     * dp[2] = 2
     * dp[3] = 3
     * dp[4] = 1
     * 
     * 
     * start from i = 2 till i*i <= number, i++
     * 
     *  i = 3 =====9 = 1
     *  11-4 = 7
     */
    public static void main(String[] args) {
        int number = -1;
        Scanner scanner = new Scanner(System.in);
        do{
            number = scanner.nextInt();
            // int answer = leastNumberOfPerfectSquare(number);
            int answer = leastNumberOfPerfectSquareUsingLegendreTheorem(number);
            System.out.println(answer);
        }while(number != -1);
        scanner.close();
    }

    public static int leastNumberOfPerfectSquare(int number) {
        if(number<4){
            return number;
        }
        int[] dp = new int[number+1];
        dp[0] = 0;dp[1] = 1;dp[2] = 2;dp[3] = 3;
        for (int i = 4; i < dp.length; i++) {
            int minCount = number;
            for(int perfectSqrt = 2;perfectSqrt*perfectSqrt <= i;perfectSqrt++){
                minCount = Math.min(minCount, 1+dp[i-perfectSqrt*perfectSqrt]);
            }
            dp[i] = minCount;
        }
        System.out.println(Arrays.toString(dp));
        return dp[number];
    }
//Therefore, it is proved that the minimum number of squares to represent any number N can only be within the set {1, 2, 3, 4}. 
//Thus, only checking for these 4 possible values, the minimum number of squares to represent any number N can be found. Follow the steps below:
// If N is a perfect square, then the result is 1.
// If N can be expressed as the sum of two squares, then the result is 2.
// If N cannot be expressed in the form of N = 4a (8b+7), where a and b are non-negative integers, then the result is 3 by Legendre’s three-square theorem. 
// If all the above conditions are not satisfied, then by Lagrange’s four-square theorem, the result is 4.

    public static int leastNumberOfPerfectSquareUsingLegendreTheorem(int number) {
        if(isPerfectSquare(number))
            return 1;
           
        if(isSumOfTwoNumber(number))
            return 2;

        if(isLengendreFunction(number))
            return 3;
        return 4;
    }

    public static boolean isPerfectSquare(int number){
        int perfectSqrt = (int)Math.sqrt(number);
        return (number == perfectSqrt*perfectSqrt);
    }

    public static boolean isSumOfTwoNumber(int number){
        for(int i = 1;i*i <= number;i++){
            if(isPerfectSquare(number-i*i))
                return true;
        }
        return false;
    }

    public static boolean isLengendreFunction(int number){
        while(number%4 == 0)
            number /= 4;
        if(number%8 != 7)
            return true;
        return false;
    }
    
}
