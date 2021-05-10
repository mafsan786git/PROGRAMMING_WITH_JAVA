import java.util.Scanner;

public class Knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int weight = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            System.out.println(maximumProfit(arr,weight));
        }
        sc.close();
    }

    private static long maximumProfit(int[][] arr, int weight) {
        int[][] dp = new int[arr.length][weight+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(i == 0){
                    if(arr[i][0] <= j)
                        dp[i][j] = arr[i][1];
                }else{
                    if(arr[i][0] <= j)
                        dp[i][j] = Math.max(dp[i-1][j], arr[i][1] + dp[i-1][j-arr[i][0]]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return dp[arr.length-1][weight];
    }
}
