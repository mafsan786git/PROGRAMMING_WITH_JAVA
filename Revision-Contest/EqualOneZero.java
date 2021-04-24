import java.io.*;
import java.util.*;

public class EqualOneZero {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[] arr = new int[n];
            input = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(input.nextToken());
                if(arr[i] == 0)
                    arr[i] = -1;
            }
            System.out.println(maxLengthSubArray(arr));

        }
    }
    private static int maxLengthSubArray(int[] arr){
        int mxLen=0;
        int end = 0;
        HashMap<Long,Integer> map = new HashMap<>();

        long sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == 0){
                mxLen = i+1;
                end = i;
            }
            if(map.containsKey(sum)){
                if(mxLen < i-map.get(sum))
                {
                    mxLen = i-map.get(sum);
                    end = i;
                }
            }else
                map.put(sum,i);
        }
        int start = end - mxLen + 1;
        System.out.println(start + " " + end);
        return mxLen;
    }
}
