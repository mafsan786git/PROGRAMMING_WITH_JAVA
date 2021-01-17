import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodingPractice {
    static int ValidDays(long time,long[] arr,int days){
        
        long total = 0;
        int i=0;
        int count=0;
        for (i = 0; i < arr.length; i++) {
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
        if(days == count)
            return 0;
        else if(count > days)
            return 1;
        return -1;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        long sum=0;
        long[] arr = new long[n];
        int i=0;
        long low=0;
        while(input.hasMoreTokens())
        {
            arr[i++] = Long.parseLong(input.nextToken());
            sum += arr[i-1];
            low = Math.max(low, arr[i-1]);
        }
        // System.out.println(sum + " " + low);
        long high = sum;
        long mid =0;
        long ans=0;
        while(low <= high){
            mid = low+(high-low)/2;
            // System.out.println("mid - " + mid);
            int x = ValidDays(mid, arr, m);
            if( x == 0)
            {
                ans = mid;
                high = mid-1;
                
            }else if(x > 0)
                low = mid+1;
            else
                high = mid-1;
                // System.out.println("mid - " + mid + " ans - " + ans);
        }
        System.out.println(ans);
    }
    
}
