import java.io.*;
import java.util.*;

public class BrickStack {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int low = 1;
        int high = n;
        int mid =  0;
        int ans = 0;
        long temp=0,act=2*n;
        while(low<=high){
            mid = low + (high-low)/2;
             temp = (long)mid * (long)(mid+1);
            if(temp == act)
            {
                ans = mid;
                break;
            }
            if(temp > act)
                high = mid-1;
            else
                {
                    ans = mid;
                    low = mid+1;
                }
        }
        System.out.println(ans);
    }
    
}
