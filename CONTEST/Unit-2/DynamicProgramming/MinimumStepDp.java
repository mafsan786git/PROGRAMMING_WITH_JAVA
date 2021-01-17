import java.util.Scanner;

public class MinimumStepDp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minStepRecur(arr,n));
        sc.close();
    }

    private static int minStepRecur(int[] arr, int n) {
        
        int[] dp = new int[n];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = n;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(j+arr[j] >= i)
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }
        return dp[n-1];
    }
}
