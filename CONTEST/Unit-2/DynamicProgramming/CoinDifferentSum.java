import java.util.Scanner;

public class CoinDifferentSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coin = new int[]{1,3,4};
        int[][] dp = new int[3][n+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(coinChangeDifferent(coin,dp,0,n));
        sc.close();
    }

    private static int coinChangeDifferent(int[] coin,int[][] dp,int row,int col) {

        if(col == 0)
            return 1;
        if(row == 3)
            return 0;
        if(dp[row][col] != -1)
            return dp[row][col];
        int count = 0;
        if(coin[row] <= col)
            count = count + coinChangeDifferent(coin, dp, 0,col-coin[row]);
        count += coinChangeDifferent(coin, dp, row+1, col);
        dp[row][col] = count;
        return dp[row][col];


    }
    
}
