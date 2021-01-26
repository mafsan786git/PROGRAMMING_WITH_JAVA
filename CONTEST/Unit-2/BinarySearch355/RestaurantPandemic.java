import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
Description :
    You have a restaurant at a beachside which has N dining tables. Each dining table has only one chair so each table can accommodate only one person. These dining tables are along a straight line parallel to the beach at positions x1,...,xN.
    C customers are currently queued up outside the restaurant since you have reopened the restaurant after a long time due to the pandemic. You need to assign the dining tables to the customers such that the minimum distance between any two customers is as large as possible in order to take care of the precautions considering the current pandemic situation. (Consider all C customers dine at the  same time)
    Find the largest minimum distance possible.
Input :
    The first line of the input contains one integer t (1 ≤ t ≤ 10) — the number of test cases. Then t test cases follow.
    The first line of each test case contains 2 integers N (2 ≤ N ≤ 100000) and c (2 ≤ C ≤ N).
    The second line of each test case contains n integers (1 ≤ Xi ≤ 1000000000) - The elements of the array W.
Output :
    For each test case, print the answer: The largest minimum distance.
    Sample Input 1 
    2
    5 2    
    2 4 1 6 8
    5 3
    3 1 3 3 3
    Sample Output 1
    7
    0
 */
public class RestaurantPandemic{
    static boolean ValidDistance(int d,int[] arr,int cos){
        int dis = arr[0]+d;
        cos--;
        for (int i = 1; i < arr.length; i++) {
            // minDis = arr[i] - arr[j];
            if(arr[i] >= dis)
            {
                dis = arr[i]+d;
                cos--;
            }
        }
        if(cos <=0)
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int c = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int i=0;
            while(input.hasMoreTokens()){
                arr[i++] = Integer.parseInt(input.nextToken());
            }
            Arrays.sort(arr);
            int high = arr[n-1] - arr[0];
            int low = 0;
            int mid,ans=0;
            while(low <= high){
                mid = low + (high-low)/2;
                if(ValidDistance(mid,arr,c)){
                    ans = mid;
                    low = mid+1;
                }else
                    high = mid-1;
            }
            System.out.println(ans);
        }
    }
}