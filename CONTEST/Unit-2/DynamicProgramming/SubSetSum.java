import java.io.*;
import java.util.*;

public class SubSetSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int totalAmount = Integer.parseInt(input.nextToken());
        int[] amountToSpend = new int[n];
        input = new StringTokenizer(br.readLine());
        for (int i = 0; i < amountToSpend.length; i++) {
            amountToSpend[i] = Integer.parseInt(input.nextToken());
        }
        if(isSumPresent(amountToSpend,totalAmount))
            System.out.println("Party");
        else
            System.out.println("No Party");
    }
    private static boolean isSumPresent(int[] amountToSpend,int totalAmount){
        boolean[][] dp = new boolean[amountToSpend.length][totalAmount+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j == 0) dp[i][j] = true;
                else if(i == 0){
                    dp[i][j] = (amountToSpend[i] == j) ? true : false;
                }else{
                    if(amountToSpend[i] > j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-amountToSpend[i]];
                }

            }
        }

        return dp[dp.length-1][totalAmount];
    }
    
}
