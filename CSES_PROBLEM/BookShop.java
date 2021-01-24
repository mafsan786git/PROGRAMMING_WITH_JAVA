import java.io.*;
import java.util.*;
public class BookShop {
    public static void main(String[] arg) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int budget = sc.nextInt();
        int[][] grid = new int[2][n];
        for (int i = 0; i < n; i++) {
            grid[0][i] = sc.nextInt();  
        }
        for (int i = 0; i < n; i++) {
            grid[1][i] = sc.nextInt();  
        }
        int answer = maxPages(grid,budget);
        System.out.println(answer);
            
        
        sc.close();
    }

    private static int maxPages(int[][] grid,int budget) {
        int[][] dp  = new int[2][budget+1];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(grid[0][i] <= j){
                    dp[1][j] = Math.max(dp[0][j], grid[1][i] + dp[0][j-grid[0][i]]);
                }else
                    dp[1][j] = dp[0][j];
            }
            // System.out.println(Arrays.toString(dp[0]));
            // System.out.println(Arrays.toString(dp[1]));
            System.out.println();
            dp[0] = dp[1].clone();
            // System.out.println(Arrays.toString(dp[0]));
            // System.out.println(Arrays.toString(dp[1]));
            // System.out.println();System.out.println();System.out.println();
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(dp[]);
        // }
        return dp[1][budget];
    }
}
