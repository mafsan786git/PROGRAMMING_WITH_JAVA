import java.util.*;
import java.io.*;

public class EditDistance {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input= new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0 ){
            input = new StringTokenizer(br.readLine());
            String s1 = input.nextToken();
            input = new StringTokenizer(br.readLine());
            String s2 = input.nextToken();

            System.out.println(minimumEdit(s1,s2));
        }

    }

    private static int minimumEdit(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int insert = dp[i][j-1] +1 ;
                    int remove = dp[i-1][j] +1 ;
                    int subtitution = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(remove, subtitution));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
