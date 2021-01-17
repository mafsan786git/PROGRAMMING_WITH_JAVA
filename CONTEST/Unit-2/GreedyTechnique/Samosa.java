import java.util.*;
import java.io.*;

public class Samosa {
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
            int n = Integer.parseInt(input.nextToken());
            int k = Integer.parseInt(input.nextToken());
            Integer[] samosa = new Integer[n];
            input = new StringTokenizer(br.readLine());
            samosa = StringToInt(input);
            Arrays.sort(samosa);
            int i=0;
            int count=0;
            int total = 0;
            while(i < n){
                total += samosa[i];
                if(total <= k){
                    count++;
                }
                i++;
            }
                System.out.println(count);


    }
    
}
