import java.io.*;
import java.util.*;
public class LongestIncreSubDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();        
        }
        longestIncreasingSubSequences(arr,n);
        sc.close();
    }
    private static void longestIncreasingSubSequences(int[] arr,int n){
        int[] dp = new int[n];
        int[] restore = new int[n];
        for (int i = 0; i < dp.length; i++){
            dp[i] = 1;restore[i] = -1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    restore[i] = j;
                }
            }
        }
        // for (int i = 0; i < restore.length; i++) {
        //     System.out.print(dp[i] + " ");
        // }
        // System.out.println();
        int ans = dp[0];
        for (int i = 1; i < restore.length; i++) {
            if(dp[i] > ans){
                ans = dp[i];
            }
        }
        System.out.println(ans);
        // Stack<Integer> stack  = new Stack<>();
        // while(idx != -1)
        // {
        //     stack.push(arr[idx]);
        //     idx = restore[idx];
        // }
        // while(!stack.isEmpty()) {
        //     System.out.print(stack.pop() + " ");
        // }
        // System.out.println();
    }
    
}
