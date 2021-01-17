import java.util.*;
import java.io.*;

public class LongestStringNotRepeating {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[] arr = new int[n];
            input = new StringTokenizer(br.readLine());
            arr = StringToInt(input);
            System.out.println(subArrayUnique(arr));
        }
        
    }
    /**Same approach but without using two pointer */
    // private static int subArrayUnique(int[] arr) {
    //     int count = 0;
    //     int maxLength = 0;
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     for (int i = 0; i < arr.length; i++) {
    //         if(map.containsKey(arr[i]))
    //         {
    //             if(map.get(arr[i]) >= i-count)
    //             {
    //                 maxLength = Math.max(count, maxLength);
    //                 count = i - map.get(arr[i]);
    //                 map.put(arr[i], i);
    //             }else{
    //                 map.put(arr[i], i);
    //                 count++;
    //             }
    //         }else{
    //             count++;
    //             map.put(arr[i], i);
    //         }
    //     }

    //     return Math.max(maxLength, count);

    // }

    //With two pointer approach
    private static int subArrayUnique(int[] arr){
        int j=0;
        int maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]))
            {
                j = Math.max(j, map.get(arr[i])+1);
            }
            map.put(arr[i],i);
            maxLength = Math.max(maxLength, i-j+1);
        }
        return maxLength;
    }
    
}
