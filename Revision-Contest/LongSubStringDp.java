import java.io.*;
import java.util.StringTokenizer;

/**You are provided a string S. Write a program that returns length of the longest palindromic substring of that string. */
public class LongSubStringDp {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String str = input.nextToken();
        
        System.out.println(longestSubString(str));


    }
    //Using Dp O(n^2) time and space
    private static int longestSubString(String str){
        int[][] dp = new int[str.length()][str.length()];
        int left = 0,right = 0;

        for (int col = 0; col < dp.length; col++) {
            int k = col;
            for (int row = 0; row < dp.length && k < dp.length; row++) {
                if(k == row){
                    dp[row][k] = 1;
                }else if(str.charAt(k) == str.charAt(row)){
                    if(k-1 < row+1 || dp[row+1][k-1] != 0){
                        dp[row][k] = dp[row+1][k-1] + 2;
                        left = row;
                        right = k;
                    }
                }
                k++;
            }
        }
        return right-left+1;
    }
}
