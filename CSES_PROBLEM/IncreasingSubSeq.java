import java.util.Arrays;
import java.util.Scanner;

public class IncreasingSubSeq {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp,0,n,1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (input[i] > input[j]) ? Math.max(dp[j]+1,dp[i]) : dp[i];
            }
        }
        int ans  = 0;
        for(Integer val : dp){
            ans = (val > ans) ? val  : ans;
        }
        System.out.println(ans);
        sc.close();
    }
    
}
