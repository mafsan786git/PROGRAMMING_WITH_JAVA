import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PainterBoard {
    static int ValidDays(long time,int[] arr,int painter){
        
        long total = 0;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total == time){
                total = 0;
                count++;
            }else if(total > time)
            {
                total = arr[i];
                count++;
            }
            // System.out.println(total + " " + i + " "+ count);
            
        }
        if(total <= time && total !=0)
            count++;
        if(painter == count)
            return 0;
        else if(count > painter)
            return 1;
        return -1;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int p = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            long sum=0;
            int[] arr = new int[n];
            int i=0;
            long low=0;
            while(input.hasMoreTokens())
            {
                arr[i++] = Integer.parseInt(input.nextToken());
                sum += arr[i-1];
                low = Math.max(low, arr[i-1]);
            }
            // Arrays.sort(arr);
            // System.out.println(sum + " " + low);
            long high = sum;
            long mid =0;
            long ans=0;
            while(low <= high){
                mid = low+(high-low)/2;
                // System.out.println("mid - " + mid);
                int x = ValidDays(mid, arr, p);
                if( x <= 0)
                {
                    ans = mid;
                    high = mid-1;
                    
                }else if(x > 0)
                    low = mid+1;
                    // System.out.println("mid - " + mid + " ans - " + ans);
            }
            System.out.println(ans);
        }
        
    }
    
}
