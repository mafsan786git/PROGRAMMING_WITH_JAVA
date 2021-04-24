import java.util.*;
import java.io.*;

public class LargestPosNeg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(input.nextToken());
            }
            Arrays.sort(arr);
            int start = 0;
            int end = n-1;
            int ans = -1;
            while(start < end){
                if(arr[end] == -(arr[start])){
                    ans = arr[end];
                    break;
                }
                if(arr[end] > -arr[start]){
                    end--;
                }else{
                    start++;
                }
            }
            System.out.println(ans);
        }
    }   
}
