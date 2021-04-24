import java.io.*;
import java.util.*;
public class FindX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int q = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(arr);
        while(q-- > 0){
            input = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(input.nextToken());
            if(isPresent(arr, k))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static boolean isPresent(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == k)
                return true;
            if(arr[mid] > k)
                right = mid-1;
            else
                left = mid+1;
        }
        return false;
    }
    
}
