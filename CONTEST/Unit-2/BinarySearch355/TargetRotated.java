import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TargetRotated {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int target = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        int mxVal = -1;
        int low = 0;
        int high = n-1;
        int mid = 0;
        while(low<=high){
            mid = low+(high-low)/2;
            if(arr[mid] == target)
            {
                mxVal = mid;
                break;
            }
            if(arr[mid] > arr[n-1] == target > arr[n-1])
            {
                if(arr[mid] > target)
                    high = mid-1;
                else
                    low = mid+1;
                
            }
            else
            {
                if(arr[mid] > arr[n-1])
                    low = mid+1;
                else
                    high = mid-1;
            }
            
        }
        System.out.println(mxVal);
        
    }
    
}
