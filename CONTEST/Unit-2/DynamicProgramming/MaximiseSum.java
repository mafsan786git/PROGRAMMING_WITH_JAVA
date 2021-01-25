// import java.util.Arrays;
import java.util.Scanner;

public class MaximiseSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            /**Not correct Yet */
            int[][] dp = new int[3][n];
            int mx = arr[0];
            int mn = 1;
            for (int i = 1; i < dp[0].length; i++) {
                // System.out.println(mx + " " + mn);
                if(i%2 == 0)
                {
                    dp[0][i] = Math.abs(mx-arr[i])+dp[0][i-1];
                    dp[1][i] = Math.abs(mn-1)+dp[1][i-1];
                    dp[2][i] = Math.abs(arr[i]-arr[i-1])+dp[2][i-1];
                    mx = arr[i];mn = 1;
                }else{
                    dp[0][i] = Math.abs(mx-1)+dp[0][i-1];
                    dp[1][i] = Math.abs(mn-arr[i])+dp[1][i-1];
                    dp[2][i] = Math.abs(arr[i]-arr[i-1])+dp[2][i-1];
                    mx = 1;mn = arr[i];
                }
                // dp[0][i] = (mx == arr[i-1] && mx != 1) ? (Math.abs(mx-1)+dp[0][i-1]) :( Math.abs(mx-arr[i])+dp[0][i-1]);
                // dp[1][i] = (mn == 1 && mn != arr[i-1]) ? (Math.abs(mn-arr[i]) + dp[1][i-1]) :  (Math.abs(mn-1) + dp[1][i-1]);
                // mx = (mx == arr[i-1]) ? 1 : arr[i];
                // mn = (mn == 1) ? arr[i] : 1;
                // System.out.println(mx + " " + mn);
            }
            // System.out.println(Arrays.toString(dp[0]));
            // System.out.println(Arrays.toString(dp[1]));
            int ans = Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1]));
            System.out.println(ans);
        }
        sc.close();
    }
    
}
