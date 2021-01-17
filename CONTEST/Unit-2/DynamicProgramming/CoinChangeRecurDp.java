import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChangeRecurDp{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int coin = Integer.parseInt(input.nextToken());
        int lenOfArray = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] changeArray = new int[lenOfArray];
        for (int i = 0; i < changeArray.length; i++) {
            changeArray[i] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(changeArray);
        long[][] dp = new long[lenOfArray][coin+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        long totalWays = waysOfCoinChange(changeArray,coin,0,dp);
        System.out.println(totalWays);
    }

    private static long waysOfCoinChange(int[] changeArray, int coin,int index,long[][] dp) {
        if(coin == 0)
            return 1;
        if(dp[index][coin]  != -1)
            return dp[index][coin];

        long countWays = 0;
        for (int i = index; i < changeArray.length; i++) {
            if(changeArray[i] <= coin)
                countWays = countWays + waysOfCoinChange(changeArray, coin-changeArray[i], i,dp);     
        }
        dp[index][coin] = countWays;
        return dp[index][coin];
    }
}