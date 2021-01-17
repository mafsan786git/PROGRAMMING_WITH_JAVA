import java.io.IOException;

public class Knapsack01Dp {
    public static void main(String[] args) throws IOException{
        int[] profit = new int[]{1, 6, 10, 16};
        int[] weights = new int[]{1, 2, 3, 5};
        int capacity = 7;
        int[][] dp = new int[profit.length][capacity+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int profitMax = maxProfitKnapsack(profit,weights,capacity,0,dp);
        System.out.println(profitMax);
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp.length; j++) {
        //     }
        // }
    }
    //Top-Down using Memoization.
    private static int maxProfitKnapsack(int[] profit, int[] weights, int capacity, int index,int[][] dp) {
        if(capacity <= 0 || index == profit.length)
            return 0;
        if(dp[index][capacity] != -1)
            return dp[index][capacity];
        int profit1 = 0;
        if(weights[index] <= capacity){
            profit1 = profit[index]  + maxProfitKnapsack(profit, weights, capacity-weights[index],index+1,dp);
        }
        int profit2 = maxProfitKnapsack(profit, weights, capacity, index+1,dp);
        dp[index][capacity] = Math.max(profit2, profit1);
        return dp[index][capacity];
    }
    
}
