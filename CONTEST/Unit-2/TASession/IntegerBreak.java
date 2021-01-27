import java.util.Scanner;
public class IntegerBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = maxSumProduct(n);
        System.out.println(ans);
        sc.close();
    }
    
    private static int maxSumProduct(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*dp[i-j], j*(i-j)));
            }
        }
        return dp[n];
    }
}
