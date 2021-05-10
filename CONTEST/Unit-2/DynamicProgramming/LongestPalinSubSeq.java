import java.io.*;
import java.util.*;
/**
 * You are given a string S. You have to find the length of the     longest subsequence of the string which forms a palindrome.
    For instance, if S is " AABCDEBAZ";
    Longest Palindromic subsequence: ABCBA or ABDBA or ABEBA
    There are many subsequences can be found which are palindrome like, AA, BCB, ABA, BB etc but we need to find the one with the maximum length.
 */

public class LongestPalinSubSeq {
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String str = input.nextToken().toString();
        int longSub = longestPalindromeSubsequence(str);
        bw.write(longSub + "\n");
        br.close();
        bw.close();
    }

    private static int longestPalindromeSubsequence(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int j = 0; j < dp.length; j++) {
            int k = j;
            for (int i = 0; i < dp.length-j; i++) {
                if(k == i)
                    dp[i][k] = 1;
                else if(str.charAt(i) == str.charAt(k))
                    dp[i][k] = dp[i+1][k-1] + 2;
                else
                    dp[i][k] = Math.max(dp[i][k-1],dp[i+1][k]);
                k++;
            }
        }
        return dp[0][str.length()-1];
    }

}
