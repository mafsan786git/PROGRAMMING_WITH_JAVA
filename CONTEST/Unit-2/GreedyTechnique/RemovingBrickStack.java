import java.io.*;
import java.util.*;
/*
PROBLEM STATEMENT------
    You want all your bricks to be stacked. Currently, you have N stacks of bricks each with height H1, H2, H3, ... HN(assuming all bricks are of 1 unit height).You did not like the configuration much and want to change the height of each stack. To increase the height of a particular stack you can add some bricks to it and to decrease the height you can take out some bricks from that stack.
    You require X units of effort for putting up an item onto the stack and Y units of effort for removing it. Find an integer which is the minimum effort required.

*/
public class RemovingBrickStack {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(input.nextToken());
            int[] initial = new int[n];
            int[] Final = new int[n];
            long totalEffort = 0;
            for(int i=0;i<n;i++){
                input = new StringTokenizer(br.readLine());
                initial[i] = Integer.parseInt(input.nextToken());
                Final[i] = Integer.parseInt(input.nextToken());
            }
            Arrays.sort(initial);
            Arrays.sort(Final);
            for (int i = 0; i < Final.length; i++) {
                if(Final[i] < initial[i])
                    totalEffort += Math.abs(Final[i]-initial[i])*y;
                else if(Final[i] > initial[i])
                    totalEffort += Math.abs(Final[i]-initial[i])*x;
            }
            
            System.out.println(totalEffort);
        }
    }
    
}
