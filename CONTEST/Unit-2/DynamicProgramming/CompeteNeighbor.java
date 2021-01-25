
// import java.util.Arrays;
import java.util.Scanner;

public class CompeteNeighbor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        long[][] dp = new long[n][n];
        for(int len = 1; len <= dp.length; len++) {
            for (int i = 0; i+len<=n; i++) {
                int j = i+len-1;
                long x=0,y=0,z=0;
                x = (i+2<=j) ? dp[i+2][j] : 0;
                y = (i+1<=j-1) ? dp[i+1][j-1] : 0;
                z = (i<=j-2) ? dp[i][j-2] : 0;

                dp[i][j] = Math.max(arr[i] + Math.min(x,y),arr[j] + Math.min(y, z));
            }
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.print(dp[0][n-1] +" "+ (sum-dp[0][n-1]));
        sc.close();
    }
    
}
