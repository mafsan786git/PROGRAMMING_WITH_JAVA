import java.io.*;
import java.util.*;
public class NikhilSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(arr);
        input = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(input.nextToken());
        while(q-- > 0){
            input = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(input.nextToken());
            int x = Integer.parseInt(input.nextToken());
            if(type == 0)
                System.out.println(isPresentFirst(arr,x));
            else
                System.out.println(isPresentSecond(arr,x));
        }
    }
    public static int isPresentFirst(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] >= k){
                ans = arr.length-mid;
                right = mid-1;
            }else
                left = mid+1;
        }
        return ans;
    }

    public static int isPresentSecond(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] > k){
                ans = arr.length-mid;
                right = mid-1;
            }else
                left = mid+1;
        }
        return ans;
    }
    
}

