import java.util.Arrays;
import java.util.Scanner;

public class MoneyAndShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[][] arr = new int[n][3];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = sc.nextInt();
            }

            System.out.println(minimumShoppingPrice(arr,n));
        }
        sc.close();
    }
    private static long minimumShoppingPrice(int[][] arr,int n){
        int[][] dp = new int[2][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            dp[1][0] = Math.min(arr[i][0] + dp[0][1], arr[i][0] + dp[0][2]);
            dp[1][1] = Math.min(arr[i][1] + dp[0][0], arr[i][1] + dp[0][2]);
            dp[1][2] = Math.min(arr[i][2] + dp[0][0], arr[i][2] + dp[0][1]);
            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            dp[0][2] = dp[1][2];
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        return Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2]));
    }
}
