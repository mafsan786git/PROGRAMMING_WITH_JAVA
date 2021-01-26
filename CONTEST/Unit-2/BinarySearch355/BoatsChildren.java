import java.io.*;
import java.util.*;
/**
 * Used two pointer ,if only two index needed to minimise then use two pointer in sorted array left and right
 */
public class BoatsChildren {

    static int ValidCheck(int[] arr,int x){
        int count = 0;
        int i=0,j = arr.length-1;
        while(i < j){
            if(arr[i] + arr[j] <= x){
                count++;j--;i++;
            }else
            {
                j--;
                count++;
            }
        }
        if(i == j)
            count++;
        return count;
    } 
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int x = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i=0;
        while(input.hasMoreTokens())
        {
            arr[i++] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(ValidCheck(arr, x));

    }
    
}
