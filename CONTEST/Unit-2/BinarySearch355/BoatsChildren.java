import java.io.*;
import java.util.*;

public class BoatsChildren {

    static int ValidCheck(int[] arr,int x){
        // int mxChild =2;
        int count = 0;
        int total = 0;
        int boat = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            count++;
            if(count <= 2){
                if(total == x ){
                    boat++;
                    total = 0;
                    count = 0;
                }else if(total > x){
                    boat++;
                    total = arr[i];
                    count=1;
                }else if(total < x && count == 2){
                    boat++;
                    total = 0;
                    count=0;
                }
            }
        }
        if(total <= x && total != 0)
            boat++;
        // if(boat >=)
        return boat;
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
        System.out.println(ValidCheck(arr, x));
        // while(low < high){
        //     mid = low + (high-low)/2;
        //     boolean flag = ValidCheck(arr,mid,x);

        // }

    }
    
}
