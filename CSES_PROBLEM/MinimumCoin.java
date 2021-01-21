import java.io.*;
import java.util.*;
public class MinimumCoin {
    public static void main(String[] arg) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] coins = new int[n];
        long[] dp = new long[sum+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();        
        }

        for (int i = 1; i < dp.length; i++) {
            long minCoin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(coins[j] <= i){
                    minCoin = Math.min(minCoin, dp[i-coins[j]]+1);
                    dp[i] = minCoin;
                }
            }
        }
        if(dp[sum] < Integer.MAX_VALUE)
            System.out.println(dp[sum]);
        else
            System.out.println(-1);
        sc.close();
    }
}
