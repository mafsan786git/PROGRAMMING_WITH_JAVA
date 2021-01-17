import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NikhilSearch {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        long[] arr = new long[n];
        int i=0;
        input = new StringTokenizer(br.readLine());
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());

        Arrays.sort(arr);
        input = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(input.nextToken());
        while(Q-- > 0){
            input = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(input.nextToken());
            long target = Long.parseLong(input.nextToken());
            int low,high,mid;
            if(type == 1){
                low = 0;high = n;mid=0;
                while(low < high){
                    mid = low + (high-low)/2;
                    // System.out.println("inside - " + mid);
                    if(arr[mid] > target)
                    {
                        high = mid;
                        // ans = mid;
                    }else
                        low = mid+1;
                }
                System.out.println(n-high);

            }else{
                low = 0;high = n;mid=0;
                while(low < high){
                    mid = low + (high-low)/2;
                    // System.out.println("inside - " + mid);
                    if(arr[mid] >= target)
                    {
                        high = mid;
                        // ans = mid;
                    }else
                        low = mid+1;
                }
                
                System.out.println(n-high);
                
            }
            // combining concept
            // if(type == 1 && high !=n && arr[high] == target)
            //         high++;
        }
   
    }
}
