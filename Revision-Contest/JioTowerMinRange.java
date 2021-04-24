import java.io.*;
import java.util.*;
public class JioTowerMinRange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr[n-1];
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(isMinimumRange(arr, mid,k) == 0){
                ans = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }
        System.out.println(ans);

        
    }
    public static int isMinimumRange(int[] arr,int dis,int k){
        int range = dis + arr[0];
        int count  = 1;
        for (int i = 1; i < arr.length; i++) {
            if(range < arr[i])
            {
                if(arr[i]-range > dis){
                    count++;
                    range = arr[i] + dis;
                }
            }
        }
        if(count <= k )
            return 0;

        return 1;
    }
    
}
