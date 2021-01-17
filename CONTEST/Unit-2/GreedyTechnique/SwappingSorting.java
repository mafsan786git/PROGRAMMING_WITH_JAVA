import java.util.*;
import java.io.*;

public class SwappingSorting {
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
            int m = Integer.parseInt(input.nextToken());
            Integer[] arr = new Integer[n];
            input = new StringTokenizer(br.readLine());
            arr = StringToInt(input);
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                int first = arr[i];
                for (int j = i+1; j < arr.length; j++) {
                    if(first > arr[j])
                    {
                        if(j-i <= m)
                        {
                            first = arr[j];
                            index = j;
                        }else
                            break;
                    }
                }
                if(index != -1){
                    for (int j = index; j > i; j--) {
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }
                    m -= index-i;
                    index = -1;
                }
                if(m <= 0)
                    break;
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
