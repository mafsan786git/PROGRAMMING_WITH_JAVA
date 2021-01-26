import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
Description :
    Sandhya is going to practice N different problems in the exact given order over the next M days. For each problem, she writes down the amount of time q[i] she will take to think and code the i-th problem.
    Before starting on the problems, she took advice from experienced competitive programmers on her practice routine and almost all of them advised her to keep her daily load at the minimum possible and avoid over training.
    Since she already has N problems to solve, she asks you to find the minimum time T such that training everyday for a time t[i]<T is sufficient to solve all the N problems in M days.
    Note : Unlike in real world, you cannot think on a problem on one day and solve it on the other day. You need to do it on the very same day!
Input :
    Input Format :
    The first line contains two space separated integers N and M. The next line contains N space separated integers denoting the time q[i] required to solve the i-th problem.
Constraints :
    N <= 100000
    M < N
    q[i] <= 1000000000000
Output
    The output consists of one integer, the minimum time T as described in the problem statement.
    Sample Input 1 
    5 3
    1 2 2 1 3
    Sample Output 1
    3
 */
public class CodingPractice {
    static int ValidDays(long time,long[] arr,int days){
        
        long total = 0;
        int i=0;
        int count=0;
        for (i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total == time){
                total = 0;
                count++;
            }else if(total > time)
            {
                total = arr[i];
                count++;
            }
        }
        if(total <= time && total !=0)
            count++;
        if(days == count)
            return 0;
        else if(count > days)
            return 1;
        return -1;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        long sum=0;
        long[] arr = new long[n];
        int i=0;
        long low=0;
        while(input.hasMoreTokens())
        {
            arr[i++] = Long.parseLong(input.nextToken());
            sum += arr[i-1];
            low = Math.max(low, arr[i-1]);
        }
        long high = sum;
        long mid =0;
        long ans=0;
        while(low <= high){
            mid = low+(high-low)/2;
            int x = ValidDays(mid, arr, m);
            if( x <= 0)
            {
                ans = mid;
                high = mid-1;
                
            }else if(x > 0)
                low = mid+1;
        }
        System.out.println(ans);
    }
    
}
