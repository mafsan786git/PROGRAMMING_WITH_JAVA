
import java.util.Scanner;

public class IncreasingSubSeq {
    public static int UpperBound(int[] arr,int right,int key){
        int left = 0;
        int ans=0;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(key<= arr[mid])
            {
                ans = mid;
                right = mid-1;
            }else
                left = mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = input[0];
        int lenMax = 1;
        for (int i = 1; i < dp.length; i++) {
            if(input[i] < dp[0])
                dp[0] = input[i];
            else if(input[i] > dp[lenMax-1])
                dp[lenMax++] = input[i];
            else
                dp[UpperBound(dp,lenMax-1, input[i])] = input[i];
            // System.out.println(Arrays.toString(dp));
        }
        System.out.println(lenMax);
        sc.close();
    }
    
}
