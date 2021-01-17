import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MachinWork{
    static int check(int mid,int[] arr,long goal){
        long sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0)
            sum += mid/arr[i];
        }
        // System.out.println(sum + " - "+ mid);
        if(sum >= goal)
            return 0;
        return 1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        long goal = Long.parseLong(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        
        int low = 1,high = 1000000000;
        int mid = 0;
        int ans=0;
        while(low<=high){
            mid = low+(high-low)/2;
            if(check(mid,arr,goal) == 0){
                high = mid-1;
                ans = mid;
            }else
                low = mid+1;
        }
        System.out.println(ans);
    }
}