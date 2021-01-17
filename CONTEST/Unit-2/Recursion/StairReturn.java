import java.io.*;
import java.util.*;
/*PROBLEM STATEMENT
    There is a stair case  with 'N' steps (0 to n-1). In every step a number x[i] (for ith step) is written on it. At each step you have two choices.
    1. Either you can to proceed to next step(i+1) or you can jump x[i] steps from that step(to i+x[i] th step).
    If the number written on the step is less than 0 , you can come down that many number of steps or climb one step up.
    Assume that initially you are standing at the 0th step. You have to find the minimum number of jumps needed to reach the top of the stair case.
    If there is no way to reach the top of the stair case, print -1 , else print the minimum number of jumps needed to reach the top of the staircase(nth step).
    If a jump results in a step , which is greater than  n, it is an invalid move.
INPUT
    Input Format :
    First line consists of 'T' , the number of test cases . In every test case , the first line consists of 'n' , the number of steps. The next line consists of n integers , x[0] to x[n-1] .
    Constraints :
    1<=T<=1000
    1<=n<=20
    -20<=x[i]<=20 and x[i] != 0
    Output
    Print the minimum number of jumps required to reach the nth step . "Nth Step" is described in the problem statement.x
Sample Input 1 
3
10
-9 8 -10 -5 3 -3 -5 3 4 1
5
1 -4 -2 5 -2
10
-3 -5 -8 5 10 -10 6 7 10 -6
Sample Output 1
3
5
6
*/
public class StairReturn {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    static int TotalMinSteps = Integer.MAX_VALUE;
    static void StairProblem(int[] arr,int index,int ans,int visited){
        if(index < 0 || index > arr.length)
            return ;
        if(index == arr.length)
        {
            TotalMinSteps = Math.min(TotalMinSteps, ans);
            return ;
        }

        if(visited > arr.length)
            return ;
            if((index + arr[index]) < arr.length &&  (index + arr[index]) >= 0){
                StairProblem(arr, index+arr[index], ans + 1, visited);
            }
            StairProblem(arr, index+1, ans+1, visited);
        // }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[] stair = new int[n];
            input = new StringTokenizer(br.readLine());
            stair = StringToInt(input);
            TotalMinSteps=Integer.MAX_VALUE;
            StairProblem(stair, 0, 0,0);
            if(TotalMinSteps == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(TotalMinSteps);
            

        }

    }
    
}
