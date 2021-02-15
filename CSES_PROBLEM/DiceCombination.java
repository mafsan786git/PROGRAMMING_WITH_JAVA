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
        //dp[n] = dp[n-1] + dp[n-2] + dp[n-3] + dp[n-4] + dp[n-5] + dp[n-6];
        //We need only last 6 values so wwe can use array of 7 and update the same array value arr[n%7]
        int[] dp = new int[7];//here in place of n size array I'm using 7 size and some modification like we need only last 6 values for any perticular n.
        dp[0] = 1;
        int mod = (int)1000000007;
        for (int i = 1; i < dp.length; i++) {
            dp[i%7] = 0;
            for (int j = 1; j < 7; j++) {
                if(j>i)
                    break;
                dp[i&7] = (dp[i%7]%mod + dp[(i-j)%7]%mod)%mod;
            }
        }
        
        bw.write(dp[n] + "\n");
        br.close();
        bw.close();
    }
}
