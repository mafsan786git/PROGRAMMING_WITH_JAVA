import java.io.*;
import java.util.*;


public class CureDesease{
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
            Integer[] vacc = new Integer[n];
            Integer[] patient = new Integer[n];
            input = new StringTokenizer(br.readLine());
            vacc = StringToInt(input);
            input = new StringTokenizer(br.readLine());
            patient = StringToInt(input);

            Arrays.sort(vacc);
            Arrays.sort(patient);
            int i=0,j=0;
            while(i < n && j<n){
                if(vacc[i] > patient[j]){
                    i++;j++;
                }
                else
                    break;
            }
            if(i == n)
                System.out.println("Yes");
            else
                System.out.println("No");

    }
}