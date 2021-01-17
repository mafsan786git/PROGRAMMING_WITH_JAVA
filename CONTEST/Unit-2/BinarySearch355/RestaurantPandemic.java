import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RestaurantPandemic{
    static boolean ValidDistance(int d,int[] arr,int cos){
        int dis = arr[0]+d;
        cos--;
        for (int i = 1; i < arr.length; i++) {
            // minDis = arr[i] - arr[j];
            if(arr[i] >= dis)
            {
                dis = arr[i]+d;
                cos--;
            }
        }
        if(cos <=0)
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int c = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int i=0;
            while(input.hasMoreTokens()){
                arr[i++] = Integer.parseInt(input.nextToken());
            }
            Arrays.sort(arr);
            int high = arr[n-1] - arr[0];
            int low = 0;
            int mid,ans=0;
            while(low <= high){
                mid = low + (high-low)/2;
                if(ValidDistance(mid,arr,c)){
                    ans = mid;
                    low = mid+1;
                }else
                    high = mid-1;
            }

            System.out.println(ans);
        }
    }
}