import java.io.*;
import java.util.*;
public class ArrayDesc {
    public static void main(String[] arg) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  
        }
        long answer = maxPages(arr,m);
        System.out.println(answer);
        sc.close();
    }
    private static long maxPages(int[] arr,int m) {
        long[][] dp  = new long[m+1][arr.length];
        int mod = (int)1000000007;
        for (int i = 0; i < dp[0].length; i++) {
            if(i == 0){
                if(arr[i] != 0) dp[arr[i]][i] = 1;
                else{
                    for (int j = 1; j < dp.length; j++) dp[j][i] = 1;
                }
                continue;
            }
            if(arr[i] != 0){
                dp[arr[i]][i] = (dp[arr[i]-1][i-1]%mod 
                                + dp[arr[i]][i-1]%mod
                                + ((arr[i]+1<=m) ? dp[arr[i]+1][i-1]%mod : 0))%mod;
            }
            else
                for (int j = 1; j < dp.length; j++) {
                    dp[j][i] = (dp[j-1][i-1]%mod
                             + dp[j][i-1]%mod
                             + ((j < m) ? dp[j+1][i-1]%mod : 0))%mod;
                }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        if(arr[arr.length-1] != 0)
            return dp[arr[arr.length-1]][arr.length-1];
        else{
            long result = 0;
            for (int i = 1; i < dp.length; i++) {
                result  = (result%mod + dp[i][arr.length-1]%mod)%mod;
            }
            return result;
        }
        
    }
}
