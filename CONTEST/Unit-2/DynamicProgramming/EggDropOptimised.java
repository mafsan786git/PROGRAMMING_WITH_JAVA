import java.util.*;

public class EggDropOptimised {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int floor = sc.nextInt();
            int egg = sc.nextInt();
            System.out.println(minOfTrial(floor,egg));
        }
        sc.close();
    }

    private static int minOfTrial(int floor, int egg) {
        int[][] dp =  new int[floor+1][egg+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = i; /**if egg is 1 then worst case is floor number */
        }
        for (int i = 1; i < dp[i].length; i++) {
            dp[1][i] = 1;  /**if floor is 1 the worst case is floor number that is 1*/
        }

        for (int f = 2; f < dp.length; f++) {
            for (int e = 2; e < dp[1].length; e++) {
                
                for (int i = 1; i < f; i++) {
                    int eggBreak = dp[i-1][e-1];
                    int eggNotBreak = dp[f-i][e];
                    System.out.println(eggBreak + " " + eggNotBreak);
                    int temp = Math.max(eggBreak, eggNotBreak)+1;
                    dp[f][e] = Math.min(dp[f][e],temp);
                    // System.out.print(dp[f][e] + " ");
                }
                System.out.println();
                
            }
        }
        for(int[] x : dp){
            System.out.println(Arrays.toString(x));
        }
        return dp[floor][egg];
    }

}
