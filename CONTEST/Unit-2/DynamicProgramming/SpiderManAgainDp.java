import java.io.*;
import java.util.*;
public class SpiderManAgainDp {
    static int[] StringToInt(StringTokenizer input) {
        int[] arr = new int[input.countTokens()];
        int i = 0;
        while (input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        int[] height = new int[n];
        input = new StringTokenizer(br.readLine());
        height  = StringToInt(input);
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= k; j++) {
                if(i-j >= 0)
                {
                    dp[i] = Math.min(dp[i],dp[i-j] + Math.abs(height[i] - height[i-j]));
                }else
                    break;
                
            }
        }
        System.out.println(dp[n-1]);
    }
}
