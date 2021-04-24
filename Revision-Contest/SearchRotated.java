import java.io.*;
import java.util.*;
public class SearchRotated {
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
        System.out.println(isPresent(arr, k));
    }
    public static int isPresent(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        int last = arr[right];
        while(left <= right){
            int mid = left + (right-left)/2;
            System.out.println(mid);
            if(arr[mid] == k)
                return mid;
            if((arr[mid] <= last && k <= last) || (arr[mid] > last && k > last)){
                if(arr[mid] > k)
                    right = mid-1;
                else
                    left = mid+1;
            }else{
                if(arr[mid] > k)
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }
    
}
