import java.io.*;
import java.util.*;

public class MinimumHeightBounce {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        int low = 1,high = n,mid = 0,ans = 0;
        while(low <= high)
        {
            mid = low + (high-low)/2;
            if((Equation(mid,k,1)+mid) >= n)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        System.out.println(ans);
    }

    private static int Equation(int H, int k,int n) {
        
        

        int temp = H/(int)(Math.pow(k, n));
        if(temp == 0)
            return 0;
        // System.out.print(temp + " ");
        return  temp + Equation(H, k, n+1);

    }
    
}
