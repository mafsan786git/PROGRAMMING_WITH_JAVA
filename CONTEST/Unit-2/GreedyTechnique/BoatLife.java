import java.util.*;
import java.io.*;

public class BoatLife {
    static Integer[] StringToInt(StringTokenizer input){
        Integer[] arr = new Integer[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int k = Integer.parseInt(input.nextToken());
            Integer[] boy = new Integer[n];
            input = new StringTokenizer(br.readLine());
            boy = StringToInt(input);

            Arrays.sort(boy);
            // System.out.println(Arrays.toString(boy));

            int count = 0;
            int i=0,j = n-1;
            while(i < j){
                if(boy[i]+ boy[j] <= k)
                {
                    count++;
                    i++;j--;
                }else if(boy[i] > boy[j]){
                    count++;
                    i++;
                }else{
                    count++;
                    j--;
                }
            }
            if( i == j)
                count++;
            System.out.println(count);

        }

    }
    
}
