import java.io.*;
import java.util.*;
public class SpiderManDp {
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
        int[] height = new int[n];
        input = new StringTokenizer(br.readLine());
        height  = StringToInt(input);
        int[] dp = new int[n];
        dp[0] = 0;dp[1] = Math.abs(height[0]-height[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1] + Math.abs(height[i] - height[i-1]),
                             dp[i-2] + Math.abs(height[i] - height[i-2]));
        }
        System.out.println(dp[n-1]);
    }
}
