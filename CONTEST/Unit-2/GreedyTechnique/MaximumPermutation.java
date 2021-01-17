import java.util.*;
import java.io.*;
/*
PROBLEM STATEMENT----
    Given an array of n elements. You can arrange the elements whichever way you want to. All you need to do is to find that permutation of integers of the array in which the sum of index multiplied by arr[index] is maximum
    Basically maximum possible value of:
    Σ arr[i] * i
TIME COMPLEXITY----
    O(LOG(N)*N)



*/
public class MaximumPermutation{
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        Arrays.sort(arr);
        int sum = 0;
        for(i=0;i<n;i++){
            sum += i*arr[i];
        }
        System.out.println(sum);
    }
}