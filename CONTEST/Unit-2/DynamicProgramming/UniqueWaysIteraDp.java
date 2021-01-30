import java.io.*;
import java.util.*;
public class UniqueWaysIteraDp {
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
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if(coins[i] <= j){
                    dp[j] = (dp[j] + dp[j-coins[i]])%1000000007;
                }
            }
        }
        System.out.println(dp[sum]);
        sc.close();
    }
}
