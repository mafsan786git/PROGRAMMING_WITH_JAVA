import java.io.*;
import java.util.*;

/*
Description------
    Tom and Nick are good friends.Once Tom asked Nick exactly N rupees, but Nick has only 1 rupee in his bank account.
    Nick wants to help his friend so he wrote two hacks First hack can multiply the amount of money he owns by 10,while the second can multiply it by 20. These hacks can be used any number of times.Can Nick help Tom with his hacks?
Input Format--------
    The first line of the input contains a single integer T denoting the number of test cases.
    The description of T test cases follows.The first and only line of each test case contains a single integer N.
Constraints---------
    1 <= T <= 100
    1 <= N <= 10^12
Output
    For each test case, print a single line containing the string "Yes" if you can make exactly N rupees or "No" otherwise.

*/

public class NickHacks {
    static boolean Nick(double n){
        if(n == (double)1)
            return true;
        if(n < (double)10)
            return false;
        if(Nick(n/10) || Nick(n/20))
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            double n = Double.parseDouble(input.nextToken());
            if(Nick(n))
                System.out.println("Yes");
            else
                System.out.println("No");
        }  
    }
    
}
