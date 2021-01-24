
import java.util.Arrays;
import java.util.Scanner;

public class RectangleCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a,b;
        a = sc.nextLong();
        b = sc.nextLong();
        int[][] dp = new int[(int)a+1][(int)b+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0, dp[i].length, Integer.MAX_VALUE);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == j)
                    dp[i][j]  = 0;
                else{
                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j],1 + dp[k][j] + dp[i-k][j]);
                    }
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j],1 + dp[i][k] + dp[i][j-k]);
                    }
                }
            }
        }
        System.out.println(dp[(int)a][(int)b]);
        sc.close();
    }
    
}
