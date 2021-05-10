import java.util.Scanner;

/**Let us say that you are given a number N, you've to find the number of different ways to write it as the sum of 1, 3 and 4.

For example, if N = 5, the answer would be 6.

1 + 1 + 1 + 1 + 1
1 + 4
4 + 1
1 + 1 + 3
1 + 3 + 1
3 + 1 + 1
 */
public class CoinWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long mod = 1000000007;
        int[] coin = new int[]{1,3,4};
        int sum = sc.nextInt();
        long[] dp = new long[sum+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                if(coin[j]<=i)
                    dp[i] = (dp[i] + dp[i-coin[j]])%mod;
            }
        }
        System.out.println(dp[sum]);
        sc.close();
    }
}
