import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LowerBound {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i=0;
        while(input.hasMoreTokens()){
            arr[i++] = Integer.parseInt(input.nextToken());
        }
        int low = 0,high = n,mid= 0;
        while(low < high){
            mid = low + (high-low)/2;
            if(arr[mid] == k)
                high = mid;
            else if(arr[mid] > k)
                high = mid-1;
            else
                low = mid+1;
        }
        if(high != n && arr[high] == k)
            System.out.println(high);
        else
            System.out.println(-1);

        
    }
    
}
