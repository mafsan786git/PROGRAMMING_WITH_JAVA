import java.util.*;
import java.io.*;

public class Casino {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int m = Integer.parseInt(input.nextToken());
            int k = Integer.parseInt(input.nextToken());
            Long[] arr = new Long[n];
            input = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(input.nextToken());
            }
            Arrays.sort(arr);
            int i = 0;
            long minTime = 0;boolean flag = true;
            while(m-- > 0){
                int temp = 0;
                if(k == 1)
                {
                    if(i < n)
                        minTime = arr[i];
                    else
                    {
                        flag = false;
                        break;
                    }
                }
                for (int j = 0; j < k; j++) {
                    
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
