import java.util.*;

public class EggDropRecursive {
    private static int[][] memo;
    public EggDropRecursive(int floor,int egg){
        memo = new int[floor+1][egg+1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int floor = sc.nextInt();
            int egg = sc.nextInt();
            new EggDropRecursive(floor,egg);
            System.out.println(minOfTrialMemo(floor,egg));
            // System.out.println(minOfTrial(floor,egg));
        }
        sc.close();
    }
    /** */
    private static int minOfTrialMemo(int floor, int egg) {
        if(floor == 1 || floor == 0)
            return floor;
        if(egg == 1)
            return floor;
        if(memo[floor][egg] != 0)
            return memo[floor][egg];
        int mn = Integer.MAX_VALUE;
        //k means kth floor
        for (int k = 1; k <=floor; k++) {
            int eggBreak;
            int eggNotBreak;
            if(memo[k-1][egg-1] != 0)
                eggBreak = memo[k-1][egg-1];
            else{
                eggBreak = minOfTrialMemo(k-1, egg-1);/*if egg breaks then come to down floor */
                memo[k-1][egg-1] = eggBreak;
            }

            if(memo[floor-k][egg] != 0)
            {
                eggNotBreak = memo[floor-k][egg];
            }else{
                eggNotBreak = minOfTrialMemo(floor-k, egg);/*if egg doesn't breaks then go to  from floor-k to floor */
                memo[floor-k][egg] = eggNotBreak;
            }
            
            int temp = Math.max(eggBreak, eggNotBreak)+1;/**Worst case for trial */
            mn = Math.min(mn, temp);/**best min number of trial */
        }
        memo[floor][egg] = mn;
        return mn;
    }
    /**Recursive */
    private static int minOfTrial(int floor, int egg) {
        if(floor == 1 || floor == 0)
            return floor;
        if(egg == 1)
            return floor;
        int mn = Integer.MAX_VALUE;
        //k means kth floor
        for (int k = 1; k <=floor; k++) {
            int eggBreak = minOfTrial(k-1, egg-1);/*if egg breaks then come to down floor */
            int eggNotBreak = minOfTrial(floor-k, egg);/*if egg doesn't breaks then go to  from floor-k to floor */
            int temp = Math.max(eggBreak, eggNotBreak)+1;/**Worst case for trial */
            mn = Math.min(mn, temp);/**best min number of trial */
        }
        return mn;
    }
}
