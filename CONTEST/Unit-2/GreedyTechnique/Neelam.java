import java.io.*;
import java.util.*;

public class Neelam {
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
            Integer[] arr = new Integer[n];
            input = new StringTokenizer(br.readLine());
            arr = StringToInt(input);
            int total = 0;
            int cost = arr[0];
            int index = 0;
            for (int j = 1; j < arr.length; j++) {
                if(cost > arr[j]){
                    total += cost*(j-index);
                    cost = arr[j];
                    index = j;
                }
                
            }
            total += cost * (n-index);
                System.out.println(total);


    }
    
}
