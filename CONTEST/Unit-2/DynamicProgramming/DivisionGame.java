
import java.util.*;
/**
 *  Alice and Bob take turns playing a cool mathematical game.       Alice        moves first.
    Initially, there is a numberNon the chalkboard.  On each player's turn, that player makes amoveconsisting of:
    Choosing anyxwith0 < x < NandN % x == 0.
    Replacing the numberNon the chalkboard withN - x.
    If player cannot make a move, they lose the game.
    return true or false depending on whether alice wins or loses.
 */

public class DivisionGame {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            boolean flag = isAliceWin(n);
            System.out.println(flag);
        }
        sc.close();
    }
    private static boolean isAliceWin(int num){
        boolean[] dp = new boolean[num+1];
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i < dp.length; i++) {
            boolean curResult = false;
            for (int j = 1; j*j < i; j++) {
                if(j == 1)
                    curResult = true^dp[i-j];
                else if(i%j == 0 ){
                    curResult = curResult | true^dp[i-j] | true^dp[i - i/j];
                }
            }
            dp[i] = curResult;
        }

        return dp[num];
    }    
}
