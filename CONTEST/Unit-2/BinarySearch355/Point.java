import java.io.*;
import java.util.*;

public class Point {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int i=0;
            int low=0;
            int high=n-1;
            while(input.hasMoreTokens())
            {
                arr[i++] = Integer.parseInt(input.nextToken());
            }
            int target = 1;
            int ans = -1;
            int mid = 0;
            while(low <= high){
                mid = low +(high -low)/2;
                if(arr[mid] == target)
                {
                    ans = mid;
                    high = mid-1;
                }
                else if(arr[mid] < target){
                    low = mid+1;
                }
            }
            System.out.println(ans);

        }
        

    }
    
}
