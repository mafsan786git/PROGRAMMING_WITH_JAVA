public class ClimbingStairs70 {
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    example : 
        n  = 4
        1,1,1,1
        1,1,2
        1,2,1
        2,1,1
        2,2
     */
    public static void main(String[] args){
        int top = 45;
        int[] memo = new int[46];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        int numberOfWays = findNumberOfWaysDPSpaceOpt(top);
        System.out.println(numberOfWays);
    }
    /**
     * if calculated for previouse then no need to calculate again
     * 1,2,3,4,5
     * 
     * @param top
     * @return
     */
    private static int findNumberOfWaysRecursiveMemo(int top,int[] memo){
        if(top < 0){
            return 0;
        }
        if(memo[top] != 0){
            return memo[top];
        }
        if(top == 1 || top == 0){
            return 1;
        }
        memo[top] = findNumberOfWaysRecursiveMemo(top-1,memo) + findNumberOfWaysRecursiveMemo(top-2,memo);
        return memo[top];
    }

    // number Ways with DP bottom Up approach
    private static int findNumberOfWaysDP(int top){
        int[] dp = new int[top+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int index = 2; index<=top;index++){
            dp[index] = dp[index-1] + dp[index-2];
        }
        return dp[top];
    }

    //With Space Optimisation DP approach
    /**
     * As we can see in Tabulation we need only last two values to calculate current
     * so we can take these values and start calculating with these values
     */
    private static int findNumberOfWaysDPSpaceOpt(int top){
        int first = 1;
        int second = 1;
        int third = 1;
        for(int index = 2; index<=top;index++){
            third = first + second;
            first = second;
            second  = third;
        }
        return third;
    }
}
