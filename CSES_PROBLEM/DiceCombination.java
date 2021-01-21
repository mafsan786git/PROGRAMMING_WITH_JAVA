import java.io.*;
import java.util.*;
public class DiceCombination {
    public static void main(String[] arg) throws IOException{
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        long mod = 1000000007;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < 7; j++) {
                if(j>i)
                    break;
                dp[i] = (dp[i]%mod + dp[i-j]%mod)%mod;
            }
        }
        
        bw.write(dp[n] + "\n");
        br.close();
        bw.close();
    }
}
