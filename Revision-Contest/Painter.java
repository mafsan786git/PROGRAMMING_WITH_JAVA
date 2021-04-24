import java.io.*;
import java.util.*;
public class Painter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(input.nextToken());
        while(q-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int painter = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            long right = 0;
            long left = arr[0];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(input.nextToken());
                right += arr[i];
                left = Math.max(left, arr[i]);
            }
            
            long minTime = 0;
            while(left <= right){
                long mid = left + (right-left)/2;
                if(isMinimumRange(arr, mid,painter)){
                    minTime = mid;
                    right = mid-1;
                }
                else
                    left = mid+1;
            }
            System.out.println(minTime);
        }
        

        
    }
    public static boolean isMinimumRange(int[] arr,long time,int painter){
        long total = 0;
        int count  = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total >= time)
            {
                count++;
                if(total == time)
                    total = 0;
                else
                    total = arr[i];
            }
        }
        if(total != 0 && total <= time)
            count++;
        if(count <= painter )
            return true;

        return false;
    }
    
}

