
import java.util.*;
/**
 * 
Description :
    There are N houses in a straight line  i.e, on X-axis and K  routers whose signal has to reach the entire road of houses All routers have some  strength , which denotes the range of signal that it can cover in both the directions.
    The router's strength should not be wasted unnecessarily ,so we have to keep its range  minimum.
    Find the minimum range of strength of all , utilising all the given routers such that all houses can receive it.
Input :
    Input Format :
    The first line contains two integers, N and K - denoting the number of houses and number of routers.
    The next line contains N integers denoting the position of the houses in the straight line.
Constraints :
    1 <= N <= 10^5
    1 <= K < N
    1 <= Positioni <= 10^7
Output :
    Print the minimum range in a new line.
 */
public class MinimumRouterRange {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[] position = new int[n];
        for(int i=0;i<n;i++)
            position[i] = sc.nextInt();
        Arrays.sort(position);
        int high = (position[n-1]-position[0]+1)/2;
        int low = 0,mid = 0,ans = 0;
        while(low <= high){
            mid = low + (high-low)/2;
            if(ValidRange(position, r, mid))
            {
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        System.out.println(ans);
        sc.close();
    }
    public static boolean ValidRange(int[] position,int r, int range){
        int len = position.length;
        int dis = position[0] + range;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if(position[i] > dis)
            {
                if(position[i]-dis > range)
                {
                    count++;
                    dis = position[i] + range;
                }
            }
        }
        if(count <= r)
            return true;
        return false;
    }
}
