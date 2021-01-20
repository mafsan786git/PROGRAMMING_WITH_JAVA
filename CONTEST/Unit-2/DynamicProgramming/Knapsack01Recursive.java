import java.io.*;

public class Knapsack01Recursive {
    public static void main(String[] args) throws IOException{
        int[] profit = new int[]{60,100,120};
        int[] weights = new int[]{10,20,30};
        int capacity = 50;
        int profitMax = maxProfitKnapsack(profit,weights,capacity,0);
        System.out.println(profitMax);
    }
    
    private static int maxProfitKnapsack(int[] profit, int[] weights, int capacity, int index) {
        if(capacity <= 0 || index == profit.length)
            return 0;
        
        int profit2 = maxProfitKnapsack(profit, weights, capacity, index+1);
        int profit1 = 0;
            if(weights[index] <= capacity){
                profit1 = profit[index]  + maxProfitKnapsack(profit, weights, capacity-weights[index],index+1);
            }
        
        return Math.max(profit2, profit1);
    }
    
}
