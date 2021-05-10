import java.util.Arrays;
import java.util.Scanner;

public class SubSetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        boolean[][] dp = new boolean[n][sum+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j == 0) dp[i][j] = true;
                else if(i == 0) dp[i][j] = (arr[i] == j) ? true : false;
                else{
                    if(arr[i] > j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        sc.close();
    }
}
