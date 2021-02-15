import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDigits {
    private static List<Integer> digitsOfNumber(int n){
        List<Integer> ans = new ArrayList<>();
        while(n > 0){
            ans.add(n%10);
            n = n/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            List<Integer> digits = digitsOfNumber(i);
            for(Integer d : digits){
                if((i-d )>= 0)
                    dp[i] = Math.min(dp[i], dp[i-d] + 1);
            }
        }
        System.out.println(dp[n]);
        sc.close();
    }
    
}
