import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 Description :  
    You are planning production for an order. You have a number of machines that each have a fixed number of days to produce an item. Given that all the machines operate simultaneously, determine the minimum number of days to produce the required order.
    For example, you have to produce goal = 10 items. You have three machines that take machines = [2,3,2] days to produce an item. The following is a schedule of items produced:
    Day Production  Count
    2   2               2
    3   1               3
    4   2               5
    6   3               8
    8   2              10
    It takes 8 days to produce 10 items using these machines.
Input : 
    Input Format
    The first line consist of two integers n and goal, the size of machine and the target production.
    The next line contains n space-separated integers, machines[i].
Constraints :
    n <= 100000
    goal <= 1000000000
    machines[i] <= 1000000000
Output :
    Output Format
    Print the minimum time required to produce items considering all machines work simultaneously.
    Sample Input 1 
    2 5
    2 3
    Sample Output 1
    6
 */

public class MachinWork{
    static int check(int mid,int[] arr,long goal){
        long sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0)
                sum += mid/arr[i];
        }
        // System.out.println(sum + " - "+ mid);
        if(sum >= goal)
            return 0;
        return 1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        long goal = Long.parseLong(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        
        int low = 1,high = 1000000000;//only one machine will do 1 work every day in worst case then high can be define as maximum goal;
        int mid = 0;
        int ans=0;
        while(low<=high){
            mid = low+(high-low)/2;
            if(check(mid,arr,goal) == 0){
                high = mid-1;
                ans = mid;
            }else
                low = mid+1;
        }
        System.out.println(ans);
    }
}