import java.io.*;
import java.util.StringTokenizer;

public class SimilarText {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String virat = input.nextToken();
        input = new StringTokenizer(br.readLine());
        String rohit = input.nextToken();
        int[][] dp = new int[virat.length()+1][rohit.length()+1];

        for (int v = 1; v <=virat.length(); v++) {
            for (int r = 1; r <=rohit.length(); r++) {
                if(virat.charAt(v-1) == rohit.charAt(r-1))
                    dp[v][r] = dp[v-1][r-1] + 1;
                else
                    dp[v][r] = Math.max(dp[v-1][r], dp[v][r-1]);                
            }
        }
        System.out.println(dp[virat.length()][rohit.length()]);
    }
    
}
