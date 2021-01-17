import java.io.*;
import java.util.Arrays;


public class WoodCutter{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input= br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);
        input = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n/2; i++) {
            long x = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = x;
        }
        System.out.println(Arrays.toString(arr));
        long temp =0;
        long height = 0;
        long total = 0;
        if(n == 1 && arr[0]>=m)
            height = arr[0]-m;
        
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i-1]-arr[i];
            total += temp*i;
            System.out.println("total-> "+total);
            if(m <= total){
                temp = total - m;
                if(temp >= i)
                {
                    height = arr[i] + (temp/i);
                }else
                    height = arr[i];
                break;
            }
        }
        // System.out.println();
        System.out.println(height);

    }
}