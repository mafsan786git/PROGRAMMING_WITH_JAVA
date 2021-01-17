import java.io.*;
import java.util.*;


public class MinimumInRotated {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        
        int low = 0,high = n-1,mid=0;
        int ans =0;
        while(low <= high){
            mid = low + (high-low)/2;
            if(arr[mid] <= arr[n-1])
            {
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        System.out.println(arr[ans]);

    }
    
}
