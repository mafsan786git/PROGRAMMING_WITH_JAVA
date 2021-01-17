import java.io.*;
import java.util.*;


public class DanceNight{
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
            Integer[] boy = new Integer[n];
            Integer[] girl = new Integer[m];
            input = new StringTokenizer(br.readLine());
            boy = StringToInt(input);
            input = new StringTokenizer(br.readLine());
            girl = StringToInt(input);

            Arrays.sort(boy,Collections.reverseOrder());
            Arrays.sort(girl,Collections.reverseOrder());
            int i=0,j=0;
            while(i < n && j<m){
                if(boy[i]>girl[j]){
                    i++;j++;
                }else
                    j++;
            }
            if(i == n)
                System.out.println("YES");
            else
                System.out.println("NO");
            
            

        }

    }
}