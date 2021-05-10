// import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreSubSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int mx = dp[0];
        for (int i = 0; i < dp.length; i++) {
            mx = Math.max(mx,dp[i]);
        }
        System.out.println(mx);
        sc.close();
    }
}
