import java.io.*;
import java.util.*;

public class SumOFArray {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }

    static long SumOfArray(int arr[],int n){
        if(n == 0)
            return arr[0];
        return arr[n] + SumOfArray(arr, n-1);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input  = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[] arr = new int[n];
            input = new StringTokenizer(br.readLine());
            arr = StringToInt(input);
            System.out.println(SumOfArray(arr,n-1));
        }
    }
    
}
