import java.util.Arrays;
import java.util.Scanner;
// import java.util.concurrent.atomic.AtomicInteger;

/** https://leetcode.com/problems/maximal-square/ */
public class MaximumSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] matrix = new char[row][col];
        sc.nextLine();
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        // AtomicInteger maxSize = new AtomicInteger();
        
        // System.out.println(maximalSquareRecur(matrix,row,col,maxSize));
        System.out.println(maximalSquareDp(matrix));
        sc.close();
    }

    private static int maximalSquareDp(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j]-'0';
                    if(result < dp[i][j] ) 
                    result = dp[i][j];
                    continue;
                }
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + Integer.min(dp[i-1][j], Integer.min(dp[i-1][j-1], dp[i][j-1]));
                    
                }
                if(result < dp[i][j] ) 
                    result = dp[i][j];
                
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return result;
    }

    // private static int maximalSquareRecur(int[][] matrix, int row, int col,AtomicInteger maxSize) {
    //     if(row == 0 || col == 0){
    //         if(maxSize.get() != 0)
    //         {
    //             maxSize.set(Math.max(maxSize.get(),matrix[row][col]));
    //             return maxSize.get();
    //         }
    //     }


    //     int top = maximalSquareRecur(matrix, row-1, col);
    //     int left = maximalSquareRecur(matrix, row, col-1);
    //     int diagonal = maximalSquareRecur(matrix, row-1, col-1);
    //     int sizeTillNow = 1 + Math.min(top, Math.min(left, diagonal));
    //     return sizeTillNow;
    // }
}
