import java.io.*;
import java.util.*;

public class Kazama {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
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
        input = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(input.nextToken());
        int ans = -1;
        int mid = 0;
        boolean flag = false;
        while(low <= high){
            mid = low +(high -low)/2;
            if(arr[mid] == target)
            {
                ans = mid;
                flag = true;
                break;
            }
            if(arr[mid] > target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(flag)
            System.out.println(ans);
        else{
            if(ans == -1)
                System.out.println(n);
            else
                System.out.println(ans);
        }

    }
    
}
