import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer; 

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int Q = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i=0;
        while(input.hasMoreTokens()){
            arr[i++] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(arr);
        while(Q-- > 0){
            input = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(input.nextToken());
            int low = 0,high = n-1,mid= 0;
            boolean flag = false;
            while(low <= high){
                mid = low + (high-low)/2;
                if(arr[mid] == target)
                {
                    flag = true;
                    break;
                }
                else if(arr[mid] > target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        

        
    }
    
}
