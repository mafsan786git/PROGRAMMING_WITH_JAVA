import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WoodCutterOptimise{
    static boolean check(int x,int[] arr,long m){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > x)
                sum += arr[i]-x; 
        }
        if(sum >= m)
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);
        input = br.readLine().split(" ");
        int[] arr = new int[n];
        int high = 0;
        int low = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            high = Math.max(high, arr[i]);
        }
        System.out.println(high + " " + low);
        int mid=0;
        int ans=0;
        while(low<=high){
            mid = low + (high-low)/2;
            // System.out.println(ans);
            if(check(mid,arr,m)){
                low = mid+1;
                ans = mid;
            }else
                high = mid-1;
        }
        System.out.println(ans);
        
    }
}