import java.io.*;
import java.util.*;

public class MasaiRange {

    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int k = Integer.parseInt(input.nextToken());
            int p = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int i=0;
            int low=Integer.MAX_VALUE+1;
            int high=0;
            String s = "";
            while(input.hasMoreTokens())
            {
                arr[i++] = Integer.parseInt(input.nextToken());
                low = Math.min(low, arr[i-1]);
                high = Math.max(high, arr[i-1]);
            }
            Arrays.sort(arr);
            boolean check = true;
            int gap=0;
            i=0;
            for (int j = 1; j < arr.length; j++) {
                gap = arr[j]-arr[i];
                if(gap == p){
                    if(j-i+1 >= k)
                    {
                        check = false;
                        break;
                    }
                }else if(gap > p){
                    i++;
                }
            }



            if(check)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    
}
