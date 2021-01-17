import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AgainOptimizationDp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(input.nextToken());
            int n = Integer.parseInt(input.nextToken());
            int[] artifact = new int[n];
            int[] values = new int[n];
            for (int i = 0; i < values.length; i++) {
                input = new StringTokenizer(br.readLine());
                artifact[i] = Integer.parseInt(input.nextToken());
                values[i] = Integer.parseInt(input.nextToken());
            }
            System.out.println(maxValueRecur(artifact,values,S));
        }
    }

    private static int maxValueRecur(int[] artifact,int[] values,int capacity){
        
        int[][] dp = new int[values.length+1][capacity+1];
        for (int i = 1; i <dp.length; i++) {
            for (int j = 1; j <dp[0].length; j++) {
                int profit1 = 0;
                if(artifact[i-1] <= j)
                    profit1 = values[i-1]  + dp[i-1][j-artifact[i-1]];
                int profit2 = dp[i-1][j];
                dp[i][j] =  Math.max(profit2, profit1);
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[values.length][capacity];

    }
    
}
