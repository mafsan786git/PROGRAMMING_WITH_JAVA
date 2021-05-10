import java.util.Scanner;

public class BTMminimumStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = n;
        }
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(j+arr[j] >= i)
                    dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        System.out.println(dp[n-1]);
        sc.close();
    }
}
