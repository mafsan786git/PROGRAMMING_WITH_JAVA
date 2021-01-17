import java.io.*;
import java.util.*;

public class MinimumCoinSherlock {
    static Integer[] StringToInt(StringTokenizer input){
        Integer[] arr = new Integer[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }

    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        int[] coin = new int[]{2000,500,200,100,50,20,10,5,2,1};
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            Integer[] shopPrice = new Integer[n];
            input = new StringTokenizer(br.readLine());
            shopPrice = StringToInt(input);
            int coinMin = Integer.MAX_VALUE;
            int index = Integer.MAX_VALUE;

            for (int i = 0; i < shopPrice.length; i++) {
                int count = 0;
                int temp  = shopPrice[i];
                for (int j = 0; j < 10; j++) {
                    
                    if(temp >= coin[j])
                    {
                        count += temp/coin[j];
                        temp %= coin[j];
                    }
                }
                if(count <= coinMin)
                {
                    if(count == coinMin)
                        index = Math.min(index, shopPrice[i]);
                    else
                        index = shopPrice[i];
                    coinMin = count;
                }
            }
            System.out.println(index);

        }
    }
    
}
