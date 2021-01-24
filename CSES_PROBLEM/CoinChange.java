import java.io.*;
import java.util.*;
public class CoinChange {
    public static void main(String[] arg) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] coins = new int[n];
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();        
        }
        // int mod = 1000000007;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if(coins[j] <= i){
                    dp[i] = (dp[i] + dp[i-coins[j]])%1000000007;
                }
            }
        }
        System.out.println(dp[sum]);
        sc.close();
    }
}
