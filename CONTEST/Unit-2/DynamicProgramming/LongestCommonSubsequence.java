import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestCommonSubsequence {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String virat = input.nextToken();
        String rohit = input.nextToken();
        int lcsLength = longestComSub(virat,rohit);
        System.out.println(lcsLength);
    }
    private static int longestComSub(String virat,String rohit){
        int[][] dp = new int[virat.length()+1][rohit.length()+1];

        for (int v = 1; v < dp.length; v++) {
            for (int r = 1; r < dp[v].length; r++) {
                if(virat.charAt(v-1) == rohit.charAt(r-1))
                    dp[v][r] = dp[v-1][r-1] + 1;
                else
                    dp[v][r] = Math.max(dp[v][r-1], dp[v-1][r]);
            }
        }
        return dp[virat.length()][rohit.length()];
    }
    
}
